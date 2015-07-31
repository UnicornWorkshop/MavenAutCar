package entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;  
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pobocka {
	@Id  
    @GeneratedValue
	private Integer id;
	private String mesto;
	@OneToMany(mappedBy="pobocka", fetch=FetchType.EAGER)
	private Set<Auto> auta;
	@OneToMany(mappedBy="pobocka_z", fetch=FetchType.EAGER)
	private Set<Rezervace> rezervace_z;
	@OneToMany(mappedBy="pobocka_do", fetch=FetchType.EAGER)
	private Set<Rezervace> rezervace_do;
	
	public Set<Rezervace> getRezervace_z() {
		return rezervace_z;
	}

	public Set<Rezervace> getRezervace_do() {
		return rezervace_do;
	}

	public Set<Auto> getAuta() {
		return auta;
	}

	public Pobocka(){
		
	}
	
	public Pobocka(String mesto) {
		super();
		this.mesto = mesto;
	}
	
	public Integer getId() {
		return id;
	}
	public String getMesto() {
		return mesto;
	}
	public void setMesto(String mesto) {
		this.mesto = mesto;
	}
}
