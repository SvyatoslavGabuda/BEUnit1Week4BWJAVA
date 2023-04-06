package model;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
public class RivAutoRizzato extends Rivenditore {

	private double orarioApertura;
	private double orarioChiusura;

	// GETTER&SETTER
	public double getOrarioApertura() {
		return orarioApertura;
	}

	public void setOrarioApertura(double orarioApertura) {
		this.orarioApertura = orarioApertura;
	}

	public double getOrarioChiusura() {
		return orarioChiusura;
	}

	public void setOrarioChiusura(double orarioChiusura) {
		this.orarioChiusura = orarioChiusura;
	}

	@Override
	public String toString() {
		return "RivAutoRizzato [orarioApertura=" + orarioApertura + ", orarioChiusura=" + orarioChiusura
				+ ", Numero biglietti emessi=" + getN_biglietti_emessi() + ", Id rivenditore()=" + getId_rivenditore()
				+ "] \n";
	}

}
