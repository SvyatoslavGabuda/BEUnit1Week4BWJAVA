package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Utente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_utente;
	private String nome;
	@OneToOne(mappedBy = "utente", cascade = CascadeType.REMOVE)
	@JoinColumn(name = "id_utente")
	private Tessera tessera;
	@OneToMany(mappedBy = "utente", cascade = CascadeType.REMOVE)
	private Set<Biglietto> biglietti_aquistati;

//GETTER&SETTER
	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "Utente [id utente =" + id_utente + ", nome =" + nome + ", tessera =" + tessera + "]\n ";
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Tessera getTessera() {
		return tessera;
	}

	public void setTessera(Tessera tessera) {
		this.tessera = tessera;
	}

	public Set<Biglietto> getBiglietti_aquistati() {
		return biglietti_aquistati;
	}

	public void setBiglietti_aquistati(Set<Biglietto> biglietti_aquistati) {
		this.biglietti_aquistati = biglietti_aquistati;
	}

	public long getId_utente() {
		return id_utente;
	}
}
