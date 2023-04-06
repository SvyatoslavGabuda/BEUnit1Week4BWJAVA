package dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Abbonamento;
import model.DocViaggio;
import model.Rivenditore;
import modelVeicoli.Tratta;
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
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		// trovare i docviaggio tra due date
		Query q = em.createQuery("SELECT e FROM DocViaggio e WHERE e.data_emissione BETWEEN :dataInizio AND :datafine");

		q.setParameter("dataInizio", inizio);
		q.setParameter("datafine", fine);
		try {
			return q.getResultList();

		} finally {
			em.close();
		}

	}

	public List<DocViaggio> trovaDocinBaseDistibutoreInPeriodoTempo(LocalDate inizio, LocalDate fine, long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		// trovare i docviaggio tra due date
//		RivenditoreDao rivDao = new RivenditoreDao();
//		Rivenditore r = rivDao.getByID(id);
		Query q = em.createQuery("SELECT e FROM DocViaggio e WHERE e.data_emissione BETWEEN :dataInizio AND :datafine "
				+ "AND e.vendutoDa = (SELECT r FROM Rivenditore r Where  r.id = :id)");
		// e.vendutoDa = :Venditore
		q.setParameter("dataInizio", inizio);
		q.setParameter("datafine", fine);
		q.setParameter("id", id);
		// q.setParameter("Venditore",r);
		try {
			return q.getResultList();

		} finally {
			em.close();
		}

	}

	public void controllaAbbonamento(Abbonamento a) {
		if (LocalDate.now().isBefore(a.getScandenza())) {
			System.out.println("l'abbonamento è valido");

		} else {
			System.out.println("L'abbonamento è scaduto");
		}
	}

	// Trovare i documenti viaggio usati su una precisa tratta

	// 1-trovare il mezzo dalla tratta
	// 2-recuperare i documenti vidimati su quel mezzo
	public List<DocViaggio> documentiPerTratta(Tratta t) {

		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

		try {
			Query q = em.createQuery(
					"SELECT d FROM DocViaggio d WHERE d.mezzoUtilizzato = (SELECT m FROM Mezzo m WHERE m.tratta = :t)");
			q.setParameter("t", t);
			return q.getResultList();

		} finally {
			em.close();
		}
	}

}
