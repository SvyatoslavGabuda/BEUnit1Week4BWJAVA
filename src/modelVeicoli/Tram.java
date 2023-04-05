package modelVeicoli;

import java.time.LocalDate;

import javax.persistence.Entity;

import utils.StatoOperativo;

@Entity
public class Tram extends Mezzo{

	public Tram() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tram(int capienza, StatoOperativo statoOperativo, LocalDate inizioManutenzione, LocalDate fineManutenzione,
			String tratta) {
		super(capienza, statoOperativo, inizioManutenzione, fineManutenzione, tratta);
		// TODO Auto-generated constructor stub
	}


}
