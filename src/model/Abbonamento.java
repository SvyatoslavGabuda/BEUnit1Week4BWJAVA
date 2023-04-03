package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import lombok.Getter;
import lombok.Setter;
import utils.TipoAbbonamento;

@Getter
@Setter
@Entity
public class Abbonamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private LocalDate data_emissione;
	private double prezzo;
	private TipoAbbonamento durata;
	private String tratta;
	@ManyToOne
	private Tessera n_tessera;
	@ManyToOne
	private Rivenditore vendutoDa;
}
