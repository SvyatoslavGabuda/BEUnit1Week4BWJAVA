package dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.DocViaggio;

import utils.JpaUtil;

public class DocViaggioDao {
	public void salva(DocViaggio v) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(v);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			em.close();
		}
	}
	public DocViaggio getByID(long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			DocViaggio v = em.find(DocViaggio.class, id);
			em.getTransaction().commit();
			return v;
		} finally {
			em.close();
		}
	}
	public void delete(DocViaggio v) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(v);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	public void update(DocViaggio v) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(v);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public List<DocViaggio> trovaDocinBaseAllaData(LocalDate inizio, LocalDate fine) {
		EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
		//trovare i docviaggio tra due date 
		Query q = em.createQuery("SELECT e FROM DocViaggio e WHERE e.data_emissione BETWEEN :dataInizio AND :datafine");
		
		q.setParameter("dataInizio", inizio);
		q.setParameter("datafine",fine);
		try {
			return q.getResultList();
			
		} finally {
			em.close();
		}
		
	}

}
