package model;



import javax.persistence.Entity;

import javax.persistence.ManyToOne;


import lombok.Getter;
import lombok.Setter;
import utils.TipoAbbonamento;


@Entity
public class Abbonamento extends DocViaggio {
	
	private TipoAbbonamento durata;
	private String tratta;
	@ManyToOne
	private Tessera tessera;
	
	//GETTER&SETTER
	public TipoAbbonamento getDurata() {
		return durata;
	}
	public void setDurata(TipoAbbonamento durata) {
		this.durata = durata;
	}
	public String getTratta() {
		return tratta;
	}
	public void setTratta(String tratta) {
		this.tratta = tratta;
	}
	public Tessera get_tessera() {
		return tessera;
	}
	public void set_tessera(Tessera tessera) {
		this.tessera = tessera;
	}
	
}
