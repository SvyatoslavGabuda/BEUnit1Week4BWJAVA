package model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_documento_viaggio")
public abstract class DocViaggio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_biglietto;
	private LocalDate data_emissione;
	private double prezzo;
	@ManyToOne
	private Rivenditore vendutoDa;
	@ManyToOne
	private Utente utente;
}
