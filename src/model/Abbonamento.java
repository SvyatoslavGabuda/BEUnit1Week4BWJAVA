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
public class Abbonamento extends DocViaggio {
	
	private TipoAbbonamento durata;
	private String tratta;
	
}
