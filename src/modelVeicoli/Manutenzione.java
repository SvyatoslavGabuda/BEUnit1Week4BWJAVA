package modelVeicoli;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class Manutenzione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private LocalDate inizioManutenzione;
	@Column(nullable = false)
	private LocalDate fineManutenzione;
	@Column
	private LocalDate fineManutenzioneEffettiva;
	@ManyToOne
	private Mezzo mezzo;

	public LocalDate getInizioManutenzione() {
		return inizioManutenzione;
	}

	public void setInizioManutenzione(LocalDate inizioManutenzione) {
		this.inizioManutenzione = inizioManutenzione;
	}

	public LocalDate getFineManutenzione() {
		return fineManutenzione;
	}

	public void setFineManutenzione(LocalDate fineManutenzione) {
		this.fineManutenzione = fineManutenzione;
	}

	public LocalDate getFineManutenzioneEffettiva() {
		return fineManutenzioneEffettiva;
	}

	public void setFineManutenzioneEffettiva(LocalDate fineManutenzioneEffettiva) {
		this.fineManutenzioneEffettiva = fineManutenzioneEffettiva;
	}

	public Mezzo getMezzo() {
		return mezzo;
	}

	public void setMezzo(Mezzo mezzo) {
		this.mezzo = mezzo;
	}

	public long getId() {
		return id;
	}

}
