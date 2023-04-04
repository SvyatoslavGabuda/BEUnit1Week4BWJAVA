package dao;

import javax.persistence.EntityManager;

import model.Abbonamento;
import model.Biglietto;
import model.Rivenditore;
import model.Utente;
import utils.JpaUtil;
import utils.TipoAbbonamento;

public class RivenditoreDao {
	public void salva(Rivenditore u) {
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
	public Rivenditore getByID(long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Rivenditore a = em.find(Rivenditore.class, id);
			em.getTransaction().commit();
			return a;
		} finally {
			em.close();
		}
	}
	public void delete(Rivenditore a) {
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
	public void update(Rivenditore a) {
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
	
	public void emettiBiglietto(Rivenditore vendutoDa, double prezzo, Long clienteId) {
		
		Biglietto nuovoBiglietto = new Biglietto();
		nuovoBiglietto.setVendutoDa(vendutoDa);
		nuovoBiglietto.setPrezzo(prezzo);
		nuovoBiglietto.setDurata(prezzo);
		UtenteDao cliente = new UtenteDao();		
		nuovoBiglietto.setUtente(cliente.getByID(clienteId));
		DocViaggioDao biglietto = new DocViaggioDao();
		biglietto.salva(nuovoBiglietto);
		//vendutoDa.aggiungiAiBigliettiEmessi(nuovoBiglietto);
		RivenditoreDao rivenditore = new RivenditoreDao();
		vendutoDa.setN_biglietti_emessi(vendutoDa.getN_biglietti_emessi() + 1);
		rivenditore.update(vendutoDa);
		
		//creazione biglietto senza id
		//poi lo carichi sul database
		//lo scarischi
		
		//metodo crea biglietto
		// beglietti emessi ++
		// inserisci nome
		// inserisci destinazione
		// paga
		// tieni biglietto EXTRA - stampare su .txt
				
	};
	
	public void emettiAbbonamento(Rivenditore vendutoDa, Long idTessera, String tratta, TipoAbbonamento tipoAbbonamento) {
		
		Abbonamento nuovoAbbonamento = new Abbonamento();
		TesseraDao tesseraDao = new TesseraDao();
		nuovoAbbonamento.setVendutoDa(vendutoDa);
		nuovoAbbonamento.set_tessera(tesseraDao.getByID(idTessera));
		nuovoAbbonamento.setTratta(tratta);
		nuovoAbbonamento.setDurata(tipoAbbonamento);
		switch (tipoAbbonamento) {
		case SETTIMANALE: 
		
		{nuovoAbbonamento.setPrezzo(500);
			break;	
		} 
		
		case MENSILE: {
			nuovoAbbonamento.setPrezzo(1000);
			break;
		}
		
		case TRIMESTRALE: {
			nuovoAbbonamento.setPrezzo(3000);
			break;
		}
		
		case SEMESTRALE: {
			nuovoAbbonamento.setPrezzo(5500);
			break;
		}
		
		case ANNUALE: {
			nuovoAbbonamento.setPrezzo(10000);
			break;
		}
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + tipoAbbonamento);
		}
		
		DocViaggioDao abbonamentoDao = new DocViaggioDao();
		RivenditoreDao rivenditoreDao = new RivenditoreDao();
		abbonamentoDao.salva(nuovoAbbonamento);
		vendutoDa.setAbbonamenti_emessi(vendutoDa.getAbbonamenti_emessi() + 1);
		rivenditoreDao.update(vendutoDa);
		
		// inserisci nome
		// inserisci n tessera
		// inserisci tratta
		// paga
		// tieni abbonamanto

	}

}
