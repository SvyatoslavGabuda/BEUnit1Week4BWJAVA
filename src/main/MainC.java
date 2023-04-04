package main;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import antlr.collections.List;
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
import utils.JpaUtil;
import utils.TipoAbbonamento;

public class MainC {
	private static final Logger l = LoggerFactory.getLogger(JpaUtil.class);
	public static void main(String[] args) {
		UtenteDao utenteDao = new UtenteDao();
		RivenditoreDao rivDao = new RivenditoreDao();
		DocViaggioDao docDao = new DocViaggioDao();
		TesseraDao tessDao = new TesseraDao();
		
		//creazione tre utenti
		Utente u1 = new Utente();
		u1.setNome("mario");
		Utente u2 = new Utente();
		u2.setNome("Luca");
		Utente u3 = new Utente();
		u3.setNome("giuseppe");
		Utente u4 = new Utente();
		u4.setNome("giuseppe2");
//		
//		utenteDao.salva(u1);
//		utenteDao.salva(u2);
 //	utenteDao.salva(u4);
		
		//lettura utenti
		Utente utenteLetto1 = utenteDao.getByID(1l);
		Utente utenteLetto2 = utenteDao.getByID(2l);
		Utente utenteLetto3 = utenteDao.getByID(3l);
		// creazione tessere
		Tessera t1 = new Tessera();
		t1.setUtente(utenteLetto1);
		t1.setData_emissione(LocalDate.of(2023,1,2));
		Tessera t2 = new Tessera();
		t2.setUtente(utenteLetto2);
		t2.setData_emissione(LocalDate.of(2023,1,2));
		//tessDao.salva(t2);
		//tessDao.salva(t1);
		System.out.println(utenteLetto1);
		System.out.println(utenteLetto2);
		System.out.println(utenteLetto3);
		
		System.out.println(utenteLetto1.getTessera());
		System.out.println(utenteLetto2.getTessera());
		System.out.println("primo");
		System.out.println(docDao.trovaDocinBaseAllaData(LocalDate.of(2020, 1, 1), LocalDate.of(2024, 1, 1)));
		System.out.println("secondo:");
	
		System.out.println(docDao.trovaDocinBaseDistibutoreInPeriodoTempo(LocalDate.of(2020, 1, 1), LocalDate.of(2024, 1, 1),1l));
		//docDao.trovaDocinBaseAllaData(LocalDate.of(2020, 1, 1), LocalDate.of(2024, 1, 1));
		
//		Tessera t2 = new Tessera();
//		t2.setUtente(utenteLetto2);
//		t2.setData_emissione(LocalDate.of(2023,1,2));
//		
//		Tessera t3 = new Tessera();
//		t3.setUtente(utenteLetto3);
//		t3.setData_emissione(LocalDate.of(2023,1,2));
		
//		tessDao.salva(t1);
//		tessDao.salva(t2);
//		
//		tessDao.salva(t3);
//		
//		utenteLetto1.setTessera(t1);
//		
//		utenteDao.update(utenteLetto1);
//		
//		utenteLetto3.setTessera(t3);
//		utenteDao.update(utenteLetto3);
//		
//		Rivenditore r1 = new RivAutoMatico();
//		rivDao.salva(r1);
//		
//		Rivenditore rivLetto = rivDao.getByID(1);
//		
//		rivDao.emettiAbbonamento(rivLetto, 1l, "milano-palermo", TipoAbbonamento.ANNUALE);
//		rivDao.emettiBiglietto(rivLetto, 10.5, 2l);
		

		
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
