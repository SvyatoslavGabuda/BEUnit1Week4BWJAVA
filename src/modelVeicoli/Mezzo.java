package modelVeicoli;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import model.Biglietto;
import utils.StatoOperativo;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public abstract class Mezzo {
	/*
	 * andrà fatto come dao--> -vidimazioneBiglietti(metodo)
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idMezzo;

	@Column(nullable = false)
	private int capienza;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private StatoOperativo statoOperativo;

	@OneToMany(mappedBy = "mezzo")
	private List<Manutenzione> manutenzione;

	@Column
	private String tratta;

	@OneToMany(mappedBy = "mezzoUtilizzato")
	private Set<Biglietto> listaBiglietti;

	public Mezzo() {
	}

	public Mezzo(int capienza, StatoOperativo statoOperativo, String tratta) {
		super();

		this.capienza = capienza;
		this.statoOperativo = statoOperativo;
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

	public void setTratta(String tratta) {
		this.tratta = tratta;
	}
		

}
