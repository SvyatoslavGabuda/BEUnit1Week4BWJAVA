package dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelVeicoli.Manutenzione;
import model.Biglietto;
import modelVeicoli.Mezzo;
import modelVeicoli.Percorrenza;
import utils.JpaUtil;
import utils.StatoOperativo;

public class MezzoDao {
	public void salva(Mezzo m) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(m);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			em.close();
		}
	}

	public Mezzo getByID(long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Mezzo m = em.find(Mezzo.class, id);
			em.getTransaction().commit();
			return m;
		} finally {
			em.close();
		}
	}

	public void delete(Mezzo m) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(m);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public void update(Mezzo m) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(m);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public void vidimazione(Mezzo m, Biglietto b) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

		try {
			if (b.isVidimato() == false) {

				b.setVidimato(true);
				b.setDataVidimazione(LocalDate.now());
				b.setMezzoUtilizzato(m);
				DocViaggioDao d = new DocViaggioDao();
				d.update(b);
				System.out.println("biglietto vidimato correttamente");
			} else {
				System.out.println("biglietto già vidimato");
			}

		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(e);
		}

		finally {
			em.close();
		}

	}

	public List<Biglietto> recuperaBigliettiVidimati(Mezzo m, LocalDate dataInizio, LocalDate dataFine) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

		try {
			Query q = em
					.createQuery("SELECT b FROM Biglietto b WHERE b.mezzoUtilizzato = :m "
							+ "AND b.dataVidimazione BETWEEN :dataInizio AND :dataFine")
					.setParameter("m", m).setParameter("dataInizio", dataInizio).setParameter("dataFine", dataFine);

			return q.getResultList();

		} finally {
			em.close();
		}
	}

	public void mandaInManutenzione(Mezzo m) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

		try {
			if(m.getStatoOperativo().equals(StatoOperativo.SERVIZIO)) {
				m.setStatoOperativo(StatoOperativo.MANUTENZIONE);
				MezzoDao mezzoDao = new MezzoDao();
				mezzoDao.update(m);
				Manutenzione manutenzione = new Manutenzione();
				manutenzione.setInizioManutenzione(LocalDate.now());
				manutenzione.setFineManutenzione(manutenzione.getInizioManutenzione().plusDays(10));
				manutenzione.setMezzo(m);
				ManutenzioneDao manDao = new ManutenzioneDao();
				manDao.salva(manutenzione);
				System.out.println("Mezzo inviato in manutenzione");
			} else {
				System.out.println("Il mezzo è già in manutenzione");
			}

		} finally {
			em.close();
		}
	}
	
	public void fineManutenzione(Mezzo m) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {

            if(m.getStatoOperativo().equals(StatoOperativo.MANUTENZIONE)) {
                ManutenzioneDao manDao = new ManutenzioneDao();
                MezzoDao mezzoDao = new MezzoDao();
                m.setStatoOperativo(StatoOperativo.SERVIZIO);
                Query q = em.createQuery("SELECT man FROM Manutenzione man WHERE man.mezzo = :m");
                q.setParameter("m", m);
                Manutenzione man = (Manutenzione) q.getSingleResult();
                man.setFineManutenzioneEffettiva(LocalDate.now());
                mezzoDao.update(m);
                manDao.update(man);
                System.out.println("Mezzo in servizio");
            } else {
                System.out.println("Il mezzo è già in servizio");
            }
        } finally {
            em.close();
        }
    }
	
	public void partenza(Mezzo m) {
		if (m.getTratta() != null) {
			Percorrenza percorso = new Percorrenza();
			PercorrenzaDao percoDao = new PercorrenzaDao();
			percorso.setTratta_associata(m.getTratta());
			percorso.setPartenza(LocalDateTime.now());
			percoDao.salva(percorso);
			System.out.println("Mezzo partito \n");
		} else {
			System.out.println("Il mezzo non dispone di una tratta");
		}
	}
	
	public void arrivo(Mezzo m) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		if (m.getTratta() != null) {
			PercorrenzaDao percoDao = new PercorrenzaDao();			
			Query q = em.createQuery("SELECT p FROM Percorrenza p WHERE p.tratta_associata = :tratta AND p.arrivo = null")
					.setParameter("tratta", m.getTratta());
			
			Percorrenza percorrenza = (Percorrenza) q.getSingleResult();	
			percorrenza.setArrivo(LocalDateTime.now());
			percoDao.update(percorrenza);
			System.out.println("Mezzo arrivato a destinazione");
			em.close();
		} else {
			System.out.println("Il mezzo non dispone di una tratta");
		}
	}
	
}
