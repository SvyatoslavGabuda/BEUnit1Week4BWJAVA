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
		Utente u1 = new Utente();
		u1.setNome("mario");
		
		Rivenditore r1 = new RivAutoMatico();  
		
		
	    DocViaggio d1 = new Biglietto();
	    d1.setPrezzo(10.2);
	    
	    DocViaggio ab1 = new Abbonamento();
	
	    
	    Tessera t1 = new Tessera();
		
		UtenteDao utenteDao = new UtenteDao();
		RivenditoreDao rivDao = new RivenditoreDao();
		DocViaggioDao docDao = new DocViaggioDao();
		TesseraDao tessDao = new TesseraDao();
		
		
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
