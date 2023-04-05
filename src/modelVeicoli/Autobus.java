package modelVeicoli;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;

import utils.StatoOperativo;

@Entity
public class Autobus extends Mezzo {

	public Autobus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Autobus(int capienza, StatoOperativo statoOperativo, List<Manutenzione> manutenzione, Tratta tratta) {
		super(capienza, statoOperativo, tratta);

		// TODO Auto-generated constructor stub
	}

}
