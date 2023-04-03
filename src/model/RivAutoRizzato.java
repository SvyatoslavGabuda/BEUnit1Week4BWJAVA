package model;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class RivAutoRizzato extends Rivenditore {
	private double orarioApertura;
	private double orarioChiusura;
//giorni di apertura/ chiusura date??

}
