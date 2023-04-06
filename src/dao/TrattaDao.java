package dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Biglietto;
import modelVeicoli.Mezzo;
import modelVeicoli.Percorrenza;
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
	
	public List<Percorrenza> recuperaNumeroPercorrenza(Tratta t, LocalDate dataInizioInput, LocalDate dataFineInput) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		LocalDateTime dataInizio = LocalDateTime.of(dataInizioInput, LocalTime.of(0,0));
		LocalDateTime dataFine = LocalDateTime.of(dataFineInput, LocalTime.of(23,59));
		try {
			Query q = em
					.createQuery("SELECT p FROM Percorrenza p WHERE p.tratta_associata = :t AND p.partenza BETWEEN :dataInizio AND :dataFine")
					.setParameter("t", t).setParameter("dataInizio", dataInizio).setParameter("dataFine", dataFine);

			return q.getResultList();

		} finally {
			em.close();
		}
		}
}
