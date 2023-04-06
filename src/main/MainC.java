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
import model.RivAutoRizzato;
import model.Rivenditore;
import model.Tessera;
import model.Utente;
import utils.JpaUtil;
import utils.StatoOperativo;
import utils.StatoRivenditoreAuto;
import utils.TipoAbbonamento;
import modelVeicoli.Autobus;
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
//		Utente u1 = new Utente();
//		u1.setNome("Emanuele");
//		Utente u2 = new Utente();
//		u2.setNome("Tommaso");
//		Utente u3 = new Utente();
//		u3.setNome("Daniele");
//		Utente u4 = new Utente();
//		u4.setNome("Vincenzo");
////		
//		utenteDao.salva(u1);
//		utenteDao.salva(u2);
//		utenteDao.salva(u3);
//		utenteDao.salva(u4);
//		
		//lettura utenti
		Utente utenteLetto1 = utenteDao.getByID(1l);
		Utente utenteLetto2 = utenteDao.getByID(2l);
		Utente utenteLetto3 = utenteDao.getByID(3l);
		Utente utenteLetto4 = utenteDao.getByID(4l);
		Utente utenteLetto5 = utenteDao.getByID(5l);
		Utente utenteLetto6 = utenteDao.getByID(6l);
		Utente utenteLetto7 = utenteDao.getByID(7l);
		Utente utenteLetto8 = utenteDao.getByID(8l);
		Utente utenteLetto9 = utenteDao.getByID(9l);
		Utente utenteLetto10 = utenteDao.getByID(10l);
		Utente utenteLetto11 = utenteDao.getByID(11l);
		Utente utenteLetto12 = utenteDao.getByID(12l);
		
		Tessera t1 = new Tessera(LocalDate.of(2022,1, 1),utenteLetto1);
		Tessera t2 = new Tessera(LocalDate.of(2022,2, 1),utenteLetto2);
		Tessera t3 = new Tessera(LocalDate.of(2022,3, 1),utenteLetto3);
		Tessera t4 = new Tessera(LocalDate.of(2022,4, 1),utenteLetto4);
		Tessera t5 = new Tessera(LocalDate.of(2022,5, 1),utenteLetto5);
		Tessera t6 = new Tessera(LocalDate.of(2022,6, 1),utenteLetto6);
		Tessera t7 = new Tessera(LocalDate.of(2022,7, 1),utenteLetto7);
		Tessera t8 = new Tessera(LocalDate.of(2022,8, 1),utenteLetto8);
		Tessera t9 = new Tessera(LocalDate.of(2022,9, 1),utenteLetto9);
		Tessera t10 = new Tessera(LocalDate.of(2022,10, 1),utenteLetto10);
		Tessera t11 = new Tessera(LocalDate.of(2022,11, 1),utenteLetto11);
		Tessera t12 = new Tessera(LocalDate.of(2022,12, 1),utenteLetto12);
		
//		tessDao.salva(t1);
//		tessDao.salva(t2);
//		tessDao.salva(t3);
//		tessDao.salva(t4);
//		tessDao.salva(t5);
//		tessDao.salva(t6);
//		tessDao.salva(t7);
//		tessDao.salva(t8);
//		tessDao.salva(t9);
//		tessDao.salva(t10);
//		tessDao.salva(t11);
//		tessDao.salva(t12);
		Tessera tessLetta1 = tessDao.getByID(1l);
		Tessera tessLetta2 = tessDao.getByID(2l);
		Tessera tessLetta3 = tessDao.getByID(3l);
		Tessera tessLetta4 = tessDao.getByID(4l);
		Tessera tessLetta5 = tessDao.getByID(5l);
		Tessera tessLetta6 = tessDao.getByID(6l);
		Tessera tessLetta7 = tessDao.getByID(7l);
		Tessera tessLetta8 = tessDao.getByID(8l);
		Tessera tessLetta9 = tessDao.getByID(9l);
		Tessera tessLetta10 = tessDao.getByID(10l);
		Tessera tessLetta11 = tessDao.getByID(11l);
		Tessera tessLetta12 = tessDao.getByID(12l);
		
//		
////		//rivenditori
		Rivenditore r = new RivAutoMatico();
		((RivAutoMatico) r).setStato(StatoRivenditoreAuto.ATTIVO);
		Rivenditore r1 = new RivAutoRizzato();
		((RivAutoRizzato) r1).setOrarioApertura(06.30);
		((RivAutoRizzato) r1).setOrarioChiusura(20.30);
		Rivenditore r2 = new RivAutoMatico();
		((RivAutoMatico) r2).setStato(StatoRivenditoreAuto.ATTIVO);
		Rivenditore rivLetto1 = rivDao.getByID(1l);
		Rivenditore rivLetto2 = rivDao.getByID(3l);
		Rivenditore rivLetto3 = rivDao.getByID(5l);
		Rivenditore rivLetto4 = rivDao.getByID(6l);
		Rivenditore rivLetto5 = rivDao.getByID(7l);
//		rivDao.emettiBiglietto(rivLetto1, 10, utenteLetto1.getId_utente());
//		rivDao.emettiBiglietto(rivLetto1, 12, utenteLetto2.getId_utente());
//		rivDao.emettiBiglietto(rivLetto1, 13, utenteLetto3.getId_utente());
//		rivDao.emettiBiglietto(rivLetto1, 1123, utenteLetto4.getId_utente());
//		rivDao.emettiBiglietto(rivLetto1, 11, utenteLetto5.getId_utente());
//		rivDao.emettiBiglietto(rivLetto1, 10.4, utenteLetto6.getId_utente());
//		rivDao.emettiBiglietto(rivLetto1, 10.2, utenteLetto1.getId_utente());
//		rivDao.emettiBiglietto(rivLetto2, 1, utenteLetto1.getId_utente());
//		rivDao.emettiBiglietto(rivLetto2, 11.2, utenteLetto1.getId_utente());
//		rivDao.emettiBiglietto(rivLetto2, 10123, utenteLetto1.getId_utente());
//		rivDao.emettiBiglietto(rivLetto1, 1012, utenteLetto1.getId_utente());
//		rivDao.emettiBiglietto(rivLetto1, 101, utenteLetto1.getId_utente());
//		rivDao.emettiBiglietto(rivLetto3, 102, utenteLetto7.getId_utente());
//		rivDao.emettiBiglietto(rivLetto3, 103, utenteLetto8.getId_utente());
//		rivDao.emettiBiglietto(rivLetto1, 104, utenteLetto9.getId_utente());
//		rivDao.emettiBiglietto(rivLetto1, 105, utenteLetto10.getId_utente());
//		rivDao.emettiBiglietto(rivLetto5, 106.1, utenteLetto11.getId_utente());
//		rivDao.emettiBiglietto(rivLetto4, 106.2, utenteLetto12.getId_utente());
//		rivDao.emettiBiglietto(rivLetto4, 107.2, utenteLetto12.getId_utente());
//		rivDao.emettiBiglietto(rivLetto4, 107.4, utenteLetto11.getId_utente());
//		rivDao.emettiBiglietto(rivLetto2, 1074, utenteLetto11.getId_utente());
//		rivDao.emettiBiglietto(rivLetto2, 1074, utenteLetto4.getId_utente());
//		rivDao.emettiBiglietto(rivLetto2, 1074, utenteLetto11.getId_utente());
//		rivDao.emettiBiglietto(rivLetto3, 1074, utenteLetto4.getId_utente());
//		rivDao.emettiBiglietto(rivLetto4, 1071, utenteLetto11.getId_utente());
//		rivDao.emettiBiglietto(rivLetto4, 1071, utenteLetto11.getId_utente());
//		rivDao.emettiBiglietto(rivLetto5, 1071, utenteLetto4.getId_utente());
//		rivDao.emettiBiglietto(rivLetto2, 1017, utenteLetto11.getId_utente());
//		rivDao.emettiBiglietto(rivLetto5, 1057, utenteLetto11.getId_utente());
//		rivDao.emettiBiglietto(rivLetto4, 1037, utenteLetto3.getId_utente());
//		rivDao.emettiBiglietto(rivLetto4, 1037, utenteLetto1.getId_utente());
//		rivDao.emettiBiglietto(rivLetto2, 1037, utenteLetto2.getId_utente());
//		rivDao.emettiBiglietto(rivLetto4, 1037, utenteLetto11.getId_utente());
//		rivDao.emettiBiglietto(rivLetto2, 1037, utenteLetto5.getId_utente());
//		rivDao.emettiBiglietto(rivLetto4, 1037, utenteLetto11.getId_utente());
//		rivDao.emettiBiglietto(rivLetto1, 107, utenteLetto5.getId_utente());
//		rivDao.emettiBiglietto(rivLetto4, 107, utenteLetto6.getId_utente());
//		rivDao.emettiBiglietto(rivLetto1, 107, utenteLetto11.getId_utente());
//		rivDao.emettiBiglietto(rivLetto4, 107, utenteLetto7.getId_utente());
//		rivDao.emettiBiglietto(rivLetto4, 107, utenteLetto11.getId_utente());
		
//		rivDao.emettiAbbonamento(rivLetto5, tessLetta1.getId_tessera() , "Milano-Palermo",  TipoAbbonamento.ANNUALE);
//		rivDao.emettiAbbonamento(rivLetto5, tessLetta2.getId_tessera() , "Milano-Roma",  TipoAbbonamento.MENSILE);
//		rivDao.emettiAbbonamento(rivLetto5, tessLetta3.getId_tessera() , "Torino-Genova",  TipoAbbonamento.SETTIMANALE);
//		rivDao.emettiAbbonamento(rivLetto5, tessLetta4.getId_tessera() , "Torino-Palermo",  TipoAbbonamento.SEMESTRALE);
//		rivDao.emettiAbbonamento(rivLetto5, tessLetta5.getId_tessera() , "Bologna-Palermo",  TipoAbbonamento.TRIMESTRALE);
//		rivDao.emettiAbbonamento(rivLetto5, tessLetta6.getId_tessera() , "Firenze-Palermo",  TipoAbbonamento.ANNUALE);
//		rivDao.emettiAbbonamento(rivLetto5, tessLetta7.getId_tessera() , "Napoli-Palermo",  TipoAbbonamento.ANNUALE);
//		rivDao.emettiAbbonamento(rivLetto5, tessLetta8.getId_tessera() , "Catania-Palermo",  TipoAbbonamento.ANNUALE);
//		rivDao.emettiAbbonamento(rivLetto5, tessLetta9.getId_tessera() , "Rimini-Palermo",  TipoAbbonamento.ANNUALE);
//		rivDao.emettiAbbonamento(rivLetto1, tessLetta10.getId_tessera() , "Milano-Palermo",  TipoAbbonamento.ANNUALE);
//		rivDao.emettiAbbonamento(rivLetto1, tessLetta11.getId_tessera() , "Milano-Roma",  TipoAbbonamento.MENSILE);
//		rivDao.emettiAbbonamento(rivLetto1, tessLetta1.getId_tessera() , "Torino-Genova",  TipoAbbonamento.SETTIMANALE);
//		rivDao.emettiAbbonamento(rivLetto1, tessLetta2.getId_tessera() , "Torino-Palermo",  TipoAbbonamento.SEMESTRALE);
//		rivDao.emettiAbbonamento(rivLetto1, tessLetta3.getId_tessera() , "Bologna-Palermo",  TipoAbbonamento.TRIMESTRALE);
//		rivDao.emettiAbbonamento(rivLetto1, tessLetta4.getId_tessera() , "Firenze-Palermo",  TipoAbbonamento.ANNUALE);
//		rivDao.emettiAbbonamento(rivLetto1, tessLetta5.getId_tessera() , "Napoli-Palermo",  TipoAbbonamento.ANNUALE);
//		rivDao.emettiAbbonamento(rivLetto1, tessLetta6.getId_tessera() , "Catania-Palermo",  TipoAbbonamento.ANNUALE);
//		rivDao.emettiAbbonamento(rivLetto1, tessLetta8.getId_tessera() , "Rimini-Palermo",  TipoAbbonamento.ANNUALE);
		//rivDao.salva(r);
//		rivDao.salva(r1);
//		rivDao.salva(r2);
		
//		Tratta tratta1 = new Tratta();
//		tratta1.setZona_di_partenza("Firenze");
//		tratta1.setCapolinea("Palermo");
//		tratta1.setTempo_medio_percorrenza(1200);
//		Tratta tratta2 = new Tratta();
//		tratta2.setZona_di_partenza("Roma");
//		tratta2.setCapolinea("Palermo");
//		tratta2.setTempo_medio_percorrenza(1300);
//		Tratta tratta3 = new Tratta();
//		tratta3.setZona_di_partenza("Torino");
//		tratta3.setCapolinea("Palermo");
//		tratta3.setTempo_medio_percorrenza(1400);
//		Tratta tratta4 = new Tratta();
//		tratta4.setCapolinea("Palermo");
//		tratta4.setZona_di_partenza("Rimini");
//		tratta4.setTempo_medio_percorrenza(1500);
//		Tratta tratta5 = new Tratta();
//		tratta5.setZona_di_partenza("Catania");
//		tratta5.setCapolinea("Palermo");
//		tratta5.setTempo_medio_percorrenza(10);
//		Tratta tratta6 = new Tratta();
//		tratta6.setZona_di_partenza("Bologna");
//		tratta6.setCapolinea("Palermo");
//		tratta6.setTempo_medio_percorrenza(800);
//		
//		traDao.salva(tratta1);
//		traDao.salva(tratta2);
//		traDao.salva(tratta3);
//		traDao.salva(tratta4);
//		traDao.salva(tratta5);
//		traDao.salva(tratta6);
		
		Tratta traLetta1 = traDao.getByID(1l);
		Tratta traLetta2= traDao.getByID(2l);
		Tratta traLetta3 = traDao.getByID(3l);
		Tratta traLetta4 = traDao.getByID(4l);
		Tratta traLetta5 = traDao.getByID(5l);
		Tratta traLetta6 = traDao.getByID(6l);
		Tratta traLetta7= traDao.getByID(7l);
		
		Mezzo m1 = new Tram();
		m1.setCapienza(1000);
		m1.setStatoOperativo(StatoOperativo.SERVIZIO);
		m1.setTratta(traLetta1);
		Mezzo m2 = new Tram();
		m2.setCapienza(100);
		m2.setStatoOperativo(StatoOperativo.SERVIZIO);
		m2.setTratta(traLetta2);
		Mezzo m3 = new Autobus();
		m3.setCapienza(10900);
		m3.setStatoOperativo(StatoOperativo.SERVIZIO);
		m3.setTratta(traLetta3);
		Mezzo m4 = new Tram();
		m4.setCapienza(10200);
		m4.setStatoOperativo(StatoOperativo.SERVIZIO);
		m4.setTratta(traLetta4);
		Mezzo m5 = new Autobus();
		m5.setCapienza(10100);
		m5.setStatoOperativo(StatoOperativo.SERVIZIO);
		m5.setTratta(traLetta5);
		Mezzo m6 = new Tram();
		m6.setCapienza(10400);
		m6.setStatoOperativo(StatoOperativo.SERVIZIO);
		m6.setTratta(traLetta6);
		Mezzo m7 = new Autobus();
		m7.setCapienza(10100);
		m7.setStatoOperativo(StatoOperativo.SERVIZIO);
		m7.setTratta(traLetta7);
		
//		mezzoDao.salva(m1);
//		mezzoDao.salva(m2);
//		mezzoDao.salva(m3);
//		mezzoDao.salva(m4);
//		mezzoDao.salva(m5);
//		mezzoDao.salva(m6);
//		mezzoDao.salva(m7);
		Mezzo mezzoLetto1 = mezzoDao.getByID(1l);
		Mezzo mezzoLetto2 = mezzoDao.getByID(2l);
		Mezzo mezzoLetto3 = mezzoDao.getByID(3l);
		Mezzo mezzoLetto4 = mezzoDao.getByID(4l);
		Mezzo mezzoLetto5 = mezzoDao.getByID(5l);
		Mezzo mezzoLetto6 = mezzoDao.getByID(6l);
		Mezzo mezzoLetto7 = mezzoDao.getByID(7l);
		
//		mezzoDao.partenza(mezzoLetto1);
//		mezzoDao.partenza(mezzoLetto2);
//		mezzoDao.partenza(mezzoLetto3);
//		mezzoDao.partenza(mezzoLetto4);
//		mezzoDao.partenza(mezzoLetto5);
//		mezzoDao.partenza(mezzoLetto6);
//		mezzoDao.partenza(mezzoLetto7);
		
//		mezzoDao.arrivo(mezzoLetto1);
		mezzoDao.arrivo(mezzoLetto2);
		mezzoDao.arrivo(mezzoLetto3);
		mezzoDao.arrivo(mezzoLetto4);
		mezzoDao.arrivo(mezzoLetto5);
		mezzoDao.arrivo(mezzoLetto6);
		mezzoDao.arrivo(mezzoLetto7);
		
	//	mezzoDao.mandaInManutenzione(mezzoLetto1);
		Manutenzione man1 = manDao.getByID(1);
	//	mezzoDao.fineManutenzione(man1);
		
		
		
//		mezzoDao.vidimazione(mezzoLetto1, (Biglietto)docDao.getByID(1l));
//		mezzoDao.vidimazione(mezzoLetto1, (Biglietto)docDao.getByID(2l));
//		mezzoDao.vidimazione(mezzoLetto1, (Biglietto)docDao.getByID(3l));
//		mezzoDao.vidimazione(mezzoLetto1, (Biglietto)docDao.getByID(4l));
//		mezzoDao.vidimazione(mezzoLetto2, (Biglietto)docDao.getByID(5l));
//		mezzoDao.vidimazione(mezzoLetto2, (Biglietto)docDao.getByID(6l));
//		mezzoDao.vidimazione(mezzoLetto2, (Biglietto)docDao.getByID(7l));
//		mezzoDao.vidimazione(mezzoLetto3, (Biglietto)docDao.getByID(8l));
//		mezzoDao.vidimazione(mezzoLetto3, (Biglietto)docDao.getByID(9l));
//		mezzoDao.vidimazione(mezzoLetto3, (Biglietto)docDao.getByID(10l));
//		mezzoDao.vidimazione(mezzoLetto4, (Biglietto)docDao.getByID(11l));
//		mezzoDao.vidimazione(mezzoLetto4, (Biglietto)docDao.getByID(12l));
//		mezzoDao.vidimazione(mezzoLetto5, (Biglietto)docDao.getByID(13l));
//		mezzoDao.vidimazione(mezzoLetto5, (Biglietto)docDao.getByID(14l));
//		mezzoDao.vidimazione(mezzoLetto5, (Biglietto)docDao.getByID(15l));
//		mezzoDao.vidimazione(mezzoLetto5, (Biglietto)docDao.getByID(16l));
//		mezzoDao.vidimazione(mezzoLetto6, (Biglietto)docDao.getByID(17l));
//		mezzoDao.vidimazione(mezzoLetto6, (Biglietto)docDao.getByID(18l));
//		mezzoDao.vidimazione(mezzoLetto7, (Biglietto)docDao.getByID(19l));
//		mezzoDao.vidimazione(mezzoLetto7, (Biglietto)docDao.getByID(20l));
		

		
		
//		
//		//lettura Rivenditori
//		Rivenditore rivLetto = rivDao.getByID(1l);
//		
//		// creazione biglietti
////		rivDao.emettiBiglietto(rivLetto, 2, utenteLetto1.getId_utente());	
//		System.out.println(docDao.getByID(1l));
//		
//		// creazione tratta
//		Tratta tratta1 = new Tratta();
//		tratta1.setZona_di_partenza("Milano");
//		tratta1.setCapolinea("Palermo");
//		tratta1.setTempo_medio_percorrenza(95);
//	//	traDao.salva(tratta1);
//		Tratta traLetto = traDao.getByID(1l);
//		
////		
//		//creazione mezzo
//		Mezzo tram1 = new Tram();
//		tram1.setCapienza(120);
//		tram1.setStatoOperativo(StatoOperativo.SERVIZIO);
//		tram1.setTratta(traLetto);
//		//mezzoDao.salva(tram1);
//	
//		
////		
//		//lettura mezzi - docViaggio
//		Mezzo mezzoLetto = mezzoDao.getByID(1l);
////		
//	System.out.println(traDao.recuperaNumeroPercorrenza(traLetto, LocalDate.of(2022, 1, 1), LocalDate.of(2023, 12, 12)));
//		// creare percorrenza
//		//mezzoDao.partenza(mezzoLetto);
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
