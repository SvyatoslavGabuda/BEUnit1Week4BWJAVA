package model;



import java.time.LocalDate;

import javax.persistence.Entity;

import javax.persistence.ManyToOne;


import lombok.Getter;
import lombok.Setter;
import utils.TipoAbbonamento;


@Entity
public class Abbonamento extends DocViaggio {
	
	@Override
	public String toString() {
		return "Abbonamento [durata=" + durata + ", tratta=" + tratta + ", tesseraAssociata=" + tesseraAssociata
				+ ", getData_emissione()=" + getData_emissione() + ", getPrezzo()=" + getPrezzo() + ", getVendutoDa()="
				+ getVendutoDa() + ", getUtente()=" + getUtente() + ", getId_biglietto()=" + getId_biglietto() + "]";
	}
	private TipoAbbonamento durata;
	private String tratta;
	@ManyToOne
	private Tessera tesseraAssociata;
	private LocalDate scandenza;
	
	//GETTER&SETTER
	public LocalDate getScandenza() {
		return this.scandenza;
	}
	public void setScandenza(LocalDate a) {
		this.scandenza = a;
	}
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
		return tesseraAssociata;
	}
	public void set_tessera(Tessera tessera) {
		this.tesseraAssociata = tessera;
	}
	
}
