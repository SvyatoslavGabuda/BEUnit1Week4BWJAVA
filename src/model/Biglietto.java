package model;


import javax.persistence.Entity;


import lombok.Getter;
import lombok.Setter;

@Entity
public class Biglietto extends DocViaggio{
	
	
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
