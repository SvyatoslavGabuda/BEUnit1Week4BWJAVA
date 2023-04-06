package main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import antlr.collections.List;
import dao.DocViaggioDao;
import dao.RivenditoreDao;
import dao.TesseraDao;
import dao.TrattaDao;
import dao.UtenteDao;
import model.Abbonamento;
import model.Biglietto;
import model.DocViaggio;
import model.RivAutoMatico;
import model.Rivenditore;
import model.Tessera;
import model.Utente;
import utils.JpaUtil;
import utils.StatoOperativo;
import utils.TipoAbbonamento;
import modelVeicoli.Manutenzione;
import modelVeicoli.Mezzo;
import modelVeicoli.Percorrenza;
import modelVeicoli.Tram;
import modelVeicoli.Tratta;
import dao.MezzoDao;
import dao.PercorrenzaDao;
import dao.ManutenzioneDao;

public class MainC {
	private static final Logger l = LoggerFactory.getLogger(JpaUtil.class);
	public static void main(String[] args) {
		UtenteDao utenteDao = new UtenteDao();
		RivenditoreDao rivDao = new RivenditoreDao();
		DocViaggioDao docDao = new DocViaggioDao();
		TesseraDao tessDao = new TesseraDao();
		MezzoDao mezzoDao = new MezzoDao();
		ManutenzioneDao manDao = new ManutenzioneDao();
		TrattaDao traDao = new TrattaDao();
		PercorrenzaDao percoDao = new PercorrenzaDao();
		
		
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
//		utenteDao.salva(u3);
//		utenteDao.salva(u4);
		
		//lettura utenti
//		Utente utenteLetto1 = utenteDao.getByID(1l);
//		Utente utenteLetto2 = utenteDao.getByID(2l);
//		Utente utenteLetto3 = utenteDao.getByID(3l);
//		
////		//rivenditori
//		Rivenditore r = new RivAutoMatico();
////		rivDao.salva(r);
//		
//		//lettura Rivenditori
//		Rivenditore rivLetto = rivDao.getByID(1l);
//		
//		// creazione biglietti
////		rivDao.emettiBiglietto(rivLetto, 2, utenteLetto1.getId_utente());	
//		System.out.println(docDao.getByID(1l));
//		
//		// creazione tratta
		Tratta tratta1 = new Tratta();
		tratta1.setZona_di_partenza("Milano");
		tratta1.setCapolinea("Palermo");
		tratta1.setTempo_medio_percorrenza(95);
	//	traDao.salva(tratta1);
		Tratta traLetto = traDao.getByID(1l);
		
//		
		//creazione mezzo
		Mezzo tram1 = new Tram();
		tram1.setCapienza(120);
		tram1.setStatoOperativo(StatoOperativo.SERVIZIO);
		tram1.setTratta(traLetto);
		//mezzoDao.salva(tram1);
	
		
//		
		//lettura mezzi - docViaggio
		Mezzo mezzoLetto = mezzoDao.getByID(1l);
//		
	System.out.println(traDao.recuperaNumeroPercorrenza(traLetto, LocalDate.of(2022, 1, 1), LocalDate.of(2023, 12, 12)));
		// creare percorrenza
		//mezzoDao.partenza(mezzoLetto);
		//mezzoDao.arrivo(mezzoLetto);
		
		//Percorrenza percoLetta = percoDao.getByID(1l);
	//	percoDao.calcolaDurataViaggioEffettiva(percoLetta);
	
//		Biglietto bigliettoLetto = (Biglietto) docDao.getByID(1l);
		
//		
//		//prova vidimazione
////		mezzoDao.vidimazione(mezzoLetto, bigliettoLetto);
//		
//		
//		//recupera biglietti dal mezzo
////		System.out.println(mezzoDao.recuperaBigliettiVidimati(mezzoLetto, LocalDate.of(2019, 10, 10), LocalDate.now()));
//		
//		
//		//manda in manutenzione prova
////		mezzoDao.mandaInManutenzione(mezzoLetto);
//		
//		//fine manutenzione
//		Manutenzione manLetta = manDao.getByID(1l);
//		mezzoDao.fineManutenzione(manLetta);
		
		
	}

}
