package entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Klient {
	@Id
	@GeneratedValue
	private Integer id;
	private String jmeno;
	//@OneToMany(mappedBy="klient")
	//private Set<Kontakt> kontakt;
	
	public Klient(String jmeno) {
		super();
		this.jmeno = jmeno;
	}
	
	public Klient() {
		super();
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getJmeno() {
		return jmeno;
	}
	
	public void setJmeno(String jmeno) {
		this.jmeno = jmeno;
	}
	/*
	public Set<Kontakt> getKontakt() {
		return kontakt;
	}
	
	public void setKontakt(Set<Kontakt> kontakt) {
		this.kontakt = kontakt;
	}
	*/
}