package modelVeicoli;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
	private LocalDateTime partenza;
	private LocalDateTime arrivo;
	@ManyToOne
	private Tratta tratta_associata;

	public LocalDateTime getPartenza() {
		return partenza;
	}

	public void setPartenza(LocalDateTime partenza) {
		this.partenza = partenza;
	}

	public LocalDateTime getArrivo() {
		return arrivo;
	}

	public void setArrivo(LocalDateTime arrivo) {
		this.arrivo = arrivo;
	}

	public Tratta getTratta_associata() {
		return tratta_associata;
	}

	public void setTratta_associata(Tratta tratta_associata) {
		this.tratta_associata = tratta_associata;
	}

}
