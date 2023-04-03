package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Biglietto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_biglietto;
	private LocalDate data_emissione;
	private double prezzo;
	private int durata;

	public Biglietto() {}
	@Override
	public String toString() {
		return "Biglietto [data_emissione=" + data_emissione + ", prezzo=" + prezzo + ", durata=" + durata + "]";
	}

}
