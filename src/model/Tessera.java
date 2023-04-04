package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Tessera {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_tessera;
	// validità annuale
	private LocalDate data_emissione;
	private LocalDate data_rinnovo;
	private LocalDate data_scadenza;
	
	@OneToOne
	private Utente utente;
	
	@OneToMany(mappedBy="tesseraAssociata")
	
	private List<Abbonamento> abbonamenti;

	@Override
	public String toString() {
		return "Tessera [id_tessera=" + id_tessera + ", data_emissione=" + data_emissione + ", data_rinnovo="
				+ data_rinnovo + ", data_scadenza=" + data_scadenza + ", " + ", abbonamenti="
				+  "]";
	}

	public Tessera() {
	}

	public Tessera(LocalDate data_emissione, Utente utente) {

		this.data_emissione = data_emissione;
		this.data_rinnovo = data_emissione;
		this.data_scadenza = this.data_emissione.plusYears(1);
		this.utente = utente;
	}
	// metodo aggiorna (dao)

	
	//GETTER&SETTER
	public LocalDate getData_emissione() {
		return data_emissione;
	}

	public void setData_emissione(LocalDate data_emissione) {
		this.data_emissione = data_emissione;
	}

	public LocalDate getData_rinnovo() {
		return data_rinnovo;
	}

	public void setData_rinnovo(LocalDate data_rinnovo) {
		this.data_rinnovo = data_rinnovo;
	}

	public LocalDate getData_scadenza() {
		return data_scadenza;
	}

	public void setData_scadenza(LocalDate data_scadenza) {
		this.data_scadenza = data_scadenza;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public List<Abbonamento> getAbbonamenti() {
		return abbonamenti;
	}

	public void setAbbonamenti(List<Abbonamento> abbonamenti) {
		this.abbonamenti = abbonamenti;
	}

	public long getId_tessera() {
		return id_tessera;
	}

	
	
}
