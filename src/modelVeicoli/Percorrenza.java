package modelVeicoli;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Percorrenza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private LocalDate partenza;
	private LocalDate arrivo;
	@ManyToOne
	private Tratta tratta_associata;
	public LocalDate getPartenza() {
		return partenza;
	}
	public void setPartenza(LocalDate partenza) {
		this.partenza = partenza;
	}
	public LocalDate getArrivo() {
		return arrivo;
	}
	public void setArrivo(LocalDate arrivo) {
		this.arrivo = arrivo;
	}
	public Tratta getTratta_associata() {
		return tratta_associata;
	}
	public void setTratta_associata(Tratta tratta_associata) {
		this.tratta_associata = tratta_associata;
	}
	
}
