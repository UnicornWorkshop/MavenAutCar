package entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Klient {
	@Id
	@GeneratedValue
	private Integer id;
	private String jmeno;
	@OneToMany(mappedBy="klient", fetch=FetchType.EAGER)
	private Set<Kontakt> kontakty;
	@OneToMany(mappedBy="klient", fetch=FetchType.EAGER)
	private Set<Rezervace> rezervace;
	
	public void setRezervace(Set<Rezervace> rezervace) {
		this.rezervace = rezervace;
	}

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
	
	public Set<Kontakt> getKontakty() {
		return kontakty;
	}
}