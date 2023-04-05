package dao;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Biglietto;
import modelVeicoli.Mezzo;
import utils.JpaUtil;

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

		} finally {
			em.close();
		}

	}

	public void manutenzione() {
	}
}
