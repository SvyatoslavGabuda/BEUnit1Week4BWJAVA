package model;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import modelVeicoli.Mezzo;

@Entity
public class Biglietto extends DocViaggio{
	private int durata;
	private boolean vidimato = false;
	private LocalDate dataVidimazione;
	@ManyToOne
	private Mezzo mezzoUtilizzato;
	
	public Biglietto() {}
	
	//GETTER&SETTER
	
	public int getDurata() {
		return durata;
	}
	public void setDurata(double prezzo) {
		
		this.durata = (int) (prezzo * 60);		
		
	}	
	public boolean isVidimato() {
		return vidimato;
	}
	public void setVidimato(boolean vidimato) {
		this.vidimato = vidimato;
	}
	public LocalDate getDataVidimazione() {
		return dataVidimazione;
	}
	public void setDataVidimazione(LocalDate dataVidimazione) {
		this.dataVidimazione = dataVidimazione;
	}
	public Mezzo getMezzoUtilizzato() {
		return mezzoUtilizzato;
	}
	public void setMezzoUtilizzato(Mezzo mezzoUtilizzato) {
		this.mezzoUtilizzato = mezzoUtilizzato;
	}
	@Override
	public String toString() {
		return "Biglietto [durata=" + durata + ", Data emissione =" + getData_emissione() + ", Prezzo = "
				+ getPrezzo() + ", VendutoDa =" + getVendutoDa() + ", Utente =" + getUtente()
				+ ", Id biglietto =" + getId_biglietto() + "]\n";
	}

	
}
