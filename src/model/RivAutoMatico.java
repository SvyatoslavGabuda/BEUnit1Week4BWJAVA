package model;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import utils.StatoRivenditoreAuto;
@Getter
@Setter
@Entity
public class RivAutoMatico extends Rivenditore {
private StatoRivenditoreAuto stato;

@Override
public String toString() {
	return "RivAutoMatico [stato=" + stato + ", getId_rivenditore()=" + getId_rivenditore() + ", getBiglietti_emessi()="
			+ getN_biglietti_emessi() + ", getAbbonamenti_emessi()=" + getAbbonamenti_emessi() + "]";
}
	

}
