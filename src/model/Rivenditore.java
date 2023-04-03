package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Rivenditore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_rivenditore;
	private long biglietti_emessi;
	private long abbonamenti_emessi;
	
//inserire nel dao
	public Biglietto emettiBiglietto() {
		//metodo crea biglietto
		// beglietti emessi ++
		// inserisci nome
		// inserisci destinazione
		// paga
		// tieni biglietto
		return null;
	};

	public Abbonamento emettiAbbonamento() {
		// inserisci nome
		// inserisci n tessera
		// inserisci tratta
		// paga
		// tieni abbonamanto
		return null;
	};
}
