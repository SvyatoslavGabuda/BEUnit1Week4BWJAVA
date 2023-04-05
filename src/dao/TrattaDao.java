package dao;

import javax.persistence.EntityManager;

import modelVeicoli.Tratta;
import utils.JpaUtil;

public class TrattaDao {
	
	public void salva(Tratta m) {
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

	public Tratta getByID(long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Tratta m = em.find(Tratta.class, id);
			em.getTransaction().commit();
			return m;
		} finally {
			em.close();
		}
	}

	public void delete(Tratta m) {
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

	public void update(Tratta m) {
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
