package modelVeicoli;

import java.util.List;
import javax.persistence.Entity;
import utils.StatoOperativo;

@Entity
public class Tram extends Mezzo{

	public Tram() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tram(int capienza, StatoOperativo statoOperativo, List<Manutenzione> manutenzione,
			Tratta tratta) {
		super(capienza, statoOperativo, tratta);
		// TODO Auto-generated constructor stub
	}


}
