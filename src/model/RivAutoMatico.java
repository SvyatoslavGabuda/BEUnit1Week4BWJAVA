package model;

import javax.persistence.Entity;


import utils.StatoRivenditoreAuto;

@Entity
public class RivAutoMatico extends Rivenditore {
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
	return "RivAutoMatico [stato=" + stato + ", getId_rivenditore()=" + getId_rivenditore() + ", getBiglietti_emessi()="
			+ getN_biglietti_emessi() + ", getAbbonamenti_emessi()=" + getAbbonamenti_emessi() + "]";
}


	

}
