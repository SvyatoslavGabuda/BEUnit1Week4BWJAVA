package modelVeicoli;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import utils.StatoOperativo;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public abstract class Mezzo {
	/*-capienza
	-servizio/manutenzione (enum)
	-periodomanutenzione
	andrà fatto come dao--> -vidimazioneBiglietti(metodo)*/
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idMezzo;
	
	@Column(nullable = false)
	private int capienza;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private StatoOperativo statoOperativo;
	
	@Column(nullable = false)
	private LocalDate inizioManutenzione;
	
	@Column(nullable = false)
	private LocalDate fineManutenzione;
	
	@Column(nullable = false)
	private String tratta;
	
	public Mezzo() {}
	
	public Mezzo(int capienza, StatoOperativo statoOperativo, LocalDate inizioManutenzione,
			LocalDate fineManutenzione, String tratta) {
		super();
		
		this.capienza = capienza;
		this.statoOperativo = statoOperativo;
		this.inizioManutenzione = inizioManutenzione;
		this.fineManutenzione = fineManutenzione;
		this.tratta = tratta;
	}

	public int getCapienza() {
		return capienza;
	}

	public void setCapienza(int capienza) {
		this.capienza = capienza;
	}

	public StatoOperativo getStatoOperativo() {
		return statoOperativo;
	}

	public void setStatoOperativo(StatoOperativo statoOperativo) {
		this.statoOperativo = statoOperativo;
	}

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
	
	
	
}
