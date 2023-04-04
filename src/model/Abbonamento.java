package model;



import javax.persistence.Entity;

import javax.persistence.ManyToOne;


import lombok.Getter;
import lombok.Setter;
import utils.TipoAbbonamento;

@Getter
@Setter
@Entity
public class Abbonamento extends DocViaggio {
	
	private TipoAbbonamento durata;
	private String tratta;
	@ManyToOne
	private Tessera n_tessera;
}
