package model;


import javax.persistence.Entity;


import lombok.Getter;
import lombok.Setter;

@Entity
public class Biglietto extends DocViaggio{
	
	
	@Override
	public String toString() {
		return "Biglietto [durata=" + durata + ", getData_emissione()=" + getData_emissione() + ", getPrezzo()="
				+ getPrezzo() + ", getVendutoDa()=" + getVendutoDa() + ", getUtente()=" + getUtente()
				+ ", getId_biglietto()=" + getId_biglietto() + "]";
	}

	private int durata;
	

	public Biglietto() {}
	
	


	//GETTER&SETTER
	public int getDurata() {
		return durata;
	}

	public void setDurata(double prezzo) {
		
		this.durata = (int) (prezzo * 60);		
		
	}
	
}
