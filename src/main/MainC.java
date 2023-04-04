package main;

import java.time.LocalDate;

import dao.DocViaggioDao;
import dao.RivenditoreDao;
import dao.TesseraDao;
import dao.UtenteDao;
import model.Abbonamento;
import model.Biglietto;
import model.DocViaggio;
import model.RivAutoMatico;
import model.Rivenditore;
import model.Tessera;
import model.Utente;

public class MainC {

	public static void main(String[] args) {
		UtenteDao utenteDao = new UtenteDao();
		RivenditoreDao rivDao = new RivenditoreDao();
		DocViaggioDao docDao = new DocViaggioDao();
		TesseraDao tessDao = new TesseraDao();
		
		//creazione tre utenti
//		Utente u1 = new Utente();
//		u1.setNome("mario");
//		Utente u2 = new Utente();
//		u2.setNome("Luca");
//		Utente u3 = new Utente();
//		u3.setNome("giuseppe");
//		
//		utenteDao.salva(u1);
//		utenteDao.salva(u2);
//		utenteDao.salva(u3);
		
		//lettura utenti
		Utente utenteLetto1 = utenteDao.getByID(1);
		Utente utenteLetto2 = utenteDao.getByID(2);
		Utente utenteLetto3 = utenteDao.getByID(3);
		// creazione tessere
		Tessera t1 = new Tessera();
		t1.setUtente(utenteLetto1);
		t1.setData_emissione(LocalDate.of(2023,1,2));
		Tessera t2 = new Tessera();
		t2.setUtente(utenteLetto2);
		Tessera t3 = new Tessera();
		t3.setUtente(utenteLetto3);
		
		tessDao.salva(t1);
//		tessDao.salva(t2);
//		tessDao.salva(t3);
		
		
		
		
//		Rivenditore r1 = new RivAutoMatico();  
		
		
	    
	   
	
	    
		
//		
//		
////		docDao.salva(d1);
////		ab1.setPrezzo(500.4);
////		ab1.setUtente(lettoUtente);
////		ab1.setVendutoDa(letto);
////		docDao.salva(ab1);
		
		/* 
		 * per creare un bilgietto serve :
		 * Utente-Rivenditore(biglietti creati ++??)-durata
		 * per creare un Abbonamento serve :
           -Tessera(valida)-Rivenditore(abbcreati ++??) -Utente
           -TipoAbbonamento
           -tratta
		 * 
		 * per Creare la tessera serve Utente e data emissione default(LocalData.now()??)
		 * 
		 * creare un metodo per la creazione/aggiunta di Utente 
		 * creare un metodo per la creazione/aggiunta di un rivenditore 
		 * creare un metodo che crei la tessera chiedendo un utente?
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */

		
		
		/* 
		 * per creare un bilgietto serve :
		 * Utente-Rivenditore(biglietti creati ++??)-durata
		 * per creare un Abbonamento serve :
           -Tessera(valida)-Rivenditore(abbcreati ++??) -Utente
           -TipoAbbonamento
           -tratta
		 * 
		 * per Creare la tessera serve Utente e data emissione default(LocalData.now()??)
		 * 
		 * creare un metodo per la creazione/aggiunta di Utente 
		 * creare un metodo per la creazione/aggiunta di un rivenditore 
		 * creare un metodo che crei la tessera chiedendo un utente?
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */
		
		
		

	}

}
