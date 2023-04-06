package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_documento_viaggio")
public abstract class DocViaggio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_biglietto; // cambiare in id_doc_viaggio
	@Column(nullable = false)
	private LocalDate data_emissione;
	@Column(nullable = false)
	private double prezzo;
	@ManyToOne
	private Rivenditore vendutoDa;
	@ManyToOne
	private Utente utente;

	// GETTER&SETTER
	public LocalDate getData_emissione() {
		return data_emissione;
	}

	public void setData_emissione(LocalDate data_emissione) {
		this.data_emissione = data_emissione;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public Rivenditore getVendutoDa() {
		return vendutoDa;
	}

	public void setVendutoDa(Rivenditore vendutoDa) {
		this.vendutoDa = vendutoDa;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public long getId_biglietto() {
		return id_biglietto;
	}

	@Override
	public String toString() {
		return "DocViaggio [id_biglietto=" + id_biglietto + ", data_emissione=" + data_emissione + ", prezzo=" + prezzo
				+ ", vendutoDa=" + vendutoDa + ", utente=" + utente + "]\n";
	}

}
