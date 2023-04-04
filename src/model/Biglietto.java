package model;



import javax.persistence.Entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Biglietto extends DocViaggio{
	
	
	private int durata;
	

	public Biglietto() {}


	//GETTER&SETTER
	public int getDurata() {
		return durata;
	}


	public void setDurata(int durata) {
		this.durata = durata;
	}
	
	

}
