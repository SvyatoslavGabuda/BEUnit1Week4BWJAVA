package dao;

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
}
