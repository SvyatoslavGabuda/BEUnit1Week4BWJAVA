package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import utils.StatoRivenditoreAuto;

@Entity
public class RivAutoMatico extends Rivenditore {
	@Enumerated(EnumType.STRING)
	@Column
	private StatoRivenditoreAuto stato;

//GETTER&SETTER
	public StatoRivenditoreAuto getStato() {
		return stato;
	}

	public void setStato(StatoRivenditoreAuto stato) {
		this.stato = stato;
	}

	@Override
	public String toString() {
		return "RivAutoMatico [stato=" + stato + ", Id_rivenditore =" + getId_rivenditore() + "] \n";
	}

}
