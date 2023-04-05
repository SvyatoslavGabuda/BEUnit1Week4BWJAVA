package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Rivenditore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_rivenditore;
	private long n_biglietti_emessi = 0;
	private long abbonamenti_emessi;
	@OneToMany(mappedBy = "vendutoDa")
	private List<Biglietto> bigliettiEmessi;
	@OneToMany(mappedBy = "vendutoDa")
    private List<Abbonamento> abbonamentiEmessi;
	
//inserire nel dao
	
	


	
	public void aggiungiAiBigliettiEmessi(Biglietto biglietto) {
		this.bigliettiEmessi.add(biglietto);
	}

	
	@Override
	public String toString() {
		return "Rivenditore [id_rivenditore=" + id_rivenditore + ", n_biglietti_emessi=" + n_biglietti_emessi
				+ "] \n";
	}


	//GETTER&SETTER
	public long getN_biglietti_emessi() {
		return n_biglietti_emessi;
	}

	public void setN_biglietti_emessi(long n_biglietti_emessi) {
		this.n_biglietti_emessi = n_biglietti_emessi;
	}

	public long getAbbonamenti_emessi() {
		return abbonamenti_emessi;
	}

	public void setAbbonamenti_emessi(long abbonamenti_emessi) {
		this.abbonamenti_emessi = abbonamenti_emessi;
	}

	public List<Biglietto> getBigliettiEmessi() {
		return bigliettiEmessi;
	}

	public void setBigliettiEmessi(List<Biglietto> bigliettiEmessi) {
		this.bigliettiEmessi = bigliettiEmessi;
	}

	public List<Abbonamento> getAbbonamentiEmessi() {
		return abbonamentiEmessi;
	}

	public void setAbbonamentiEmessi(List<Abbonamento> abbonamentiEmessi) {
		this.abbonamentiEmessi = abbonamentiEmessi;
	}

	public long getId_rivenditore() {
		return id_rivenditore;
	};
	
	
}
