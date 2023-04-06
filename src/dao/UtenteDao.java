package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Utente;
import modelVeicoli.Tratta;
import utils.JpaUtil;

public class UtenteDao {
	public void salva(Utente u) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			em.close();
		}
	}
	public Utente getByID(long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Utente a = em.find(Utente.class, id);
			em.getTransaction().commit();
			return a;
		} finally {
			em.close();
		}
	}
	public void delete(Utente a) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(a);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	public void update(Utente a) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(a);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	//Query per ottenere una lista di utenti che hanno validato un documento su un preciso mezzo su una precisa tratta
	public List<Utente> utentiPerTratta(Tratta t){
		
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {			
			Query q = em.createQuery("SELECT d.utente FROM DocViaggio d WHERE d.mezzoUtilizzato = (SELECT m FROM Mezzo m WHERE m.tratta = :t)");
			q.setParameter("t", t);
			return q.getResultList();
		} finally {
			em.close();
		}
	} 

}
