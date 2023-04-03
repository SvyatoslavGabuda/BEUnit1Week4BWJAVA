package main;

import dao.UtenteDao;
import model.Utente;

public class MainC {

	public static void main(String[] args) {
		Utente u1 = new Utente();
		u1.setNome("mario");
		
		UtenteDao utenteDao = new UtenteDao();
		
		utenteDao.salva(u1);
		
		

	}

}
