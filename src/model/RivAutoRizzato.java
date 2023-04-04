package model;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;


@Entity
public class RivAutoRizzato extends Rivenditore {
	private double orarioApertura;
	private double orarioChiusura;
//giorni di apertura/ chiusura date??
	
	//GETTER&SETTER
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

	
}
