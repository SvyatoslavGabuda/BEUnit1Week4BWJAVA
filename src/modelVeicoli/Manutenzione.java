package modelVeicoli;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class Manutenzione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	 
	@Column(nullable = false)
	private LocalDate inizioManutenzione;
	
	@Column(nullable = false)
	private LocalDate fineManutenzione;

	@ManyToOne
	//@JoinColumn(name="mezzo") riga inutile, nel caso volessi cambiare nome alla colonna va fatto cosi
	private Mezzo mezzo;
	
}
