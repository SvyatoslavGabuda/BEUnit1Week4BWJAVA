package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Tessera {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_tessera;
	// validità annuale
	private LocalDate data_emissione;
	private LocalDate data_rinnovo;
	private LocalDate data_scadenza;
	@OneToOne(mappedBy = "tessera",cascade = CascadeType.ALL)
	private Utente utente;
	@OneToMany(mappedBy="n_tessera",cascade = CascadeType.REMOVE)
	private List<Abbonamento> abbonamenti;

	public Tessera() {
	}

	public Tessera(LocalDate data_emissione, Utente utente) {

		this.data_emissione = data_emissione;
		this.data_rinnovo = data_emissione;
		this.data_scadenza = this.data_emissione.plusYears(1);
		this.utente = utente;
	}
	// metodo aggiorna (dao)

}
