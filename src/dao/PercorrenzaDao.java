package dao;

import java.time.Duration;

import javax.persistence.EntityManager;

import modelVeicoli.Mezzo;
import modelVeicoli.Percorrenza;
import utils.JpaUtil;

public class PercorrenzaDao {

	public void salva(Percorrenza m) {
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

	public Percorrenza getByID(long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Percorrenza m = em.find(Percorrenza.class, id);
			em.getTransaction().commit();
			return m;
		} finally {
			em.close();
		}
	}

	public void delete(Percorrenza m) {
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

	public void update(Percorrenza m) {
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
	
	public long calcolaDurataViaggioEffettiva(Percorrenza perc) {
		
		if (perc.getArrivo() != null) {
//			durata = (perc.getArrivo().getLong() - percgetLong(null)) * 60000;
			System.out.println(perc.getArrivo());
			Duration diff = Duration.between(perc.getPartenza(), perc.getArrivo());
			long durata = (long) Math.ceil(diff.getSeconds() / 60);
			System.out.println("Minuti " + durata);
			return durata;
		}
		return (Long) null;
	}
}
