package model;

import java.util.Set;

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
public class Utente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id_utente;
private String nome;
@OneToOne
private Tessera tessera;
@OneToMany(mappedBy = "utente")
private Set<Biglietto> biglietti_aquistati;
// cognome, datadinascita,residenza
}
