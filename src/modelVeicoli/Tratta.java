package modelVeicoli;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Tratta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String zona_di_partenza;
	@Column(nullable = false)
	private String capolinea;
	@Column(nullable = false)
	private int tempo_medio_percorrenza;
	@OneToOne(mappedBy = "tratta")
	private Mezzo mezzoUsato;
	@OneToMany(mappedBy = "tratta_associata")
	private List<Percorrenza> lista_percorrenze;
	
	public Tratta() {};
	
	
	// GETTER E SETTER
	public String getZona_di_partenza() {
		return zona_di_partenza;
	}
	
	public void setZona_di_partenza(String zona_di_partenza) {
		this.zona_di_partenza = zona_di_partenza;
	}
	
	public String getCapolinea() {
		return capolinea;
	}
	
	public void setCapolinea(String capolinea) {
		this.capolinea = capolinea;
	}
	
	public int getTempo_medio_percorrenza() {
		return tempo_medio_percorrenza;
	}
	
	public void setTempo_medio_percorrenza(int tempo_medio_percorrenza) {
		this.tempo_medio_percorrenza = tempo_medio_percorrenza;
	}
	
	
//	public LocalDate getPartenza() {
//		return partenza;
//	}
//	
//	public void setPartenza(LocalDate partenza) {
//		this.partenza = partenza;
//	}
//	
//	public LocalDate getArrivo() {
//		return arrivo;
//	}
//	
//	public void setArrivo(LocalDate arrivo) {
//		this.arrivo = arrivo;
//	}
	
	@Override
	public String toString() {
		return "Tratta [id=" + id + ", zona_di_partenza=" + zona_di_partenza + ", capolinea=" + capolinea
				+ ", tempo_medio_percorrenza=" + tempo_medio_percorrenza + ", mezzoUsato=" + mezzoUsato
				+ "]\n";
	}


	public long getId() {
		return id;
	}
	
	
	
}
