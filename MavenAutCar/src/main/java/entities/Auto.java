package entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Auto {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String znacka;
	private Integer vykonnost;
	private Integer velikost;
	private Integer kapacita;
	@ManyToOne
	private Pobocka pobocka;
	@ManyToMany
	private Set<Vybava> vybava;
	
	public Auto(String znacka, Integer vykonnost, Integer velikost, Integer kapacita) {
		super();
		this.znacka = znacka;
		this.vykonnost = vykonnost;
		this.velikost = velikost;
		this.kapacita = kapacita;
	}

	public Auto() {
		super();
	}

	public Integer getId() {
		return id;
	}
	
	public Pobocka getPobocka() {
		return pobocka;
	}

	public void setPobocka(Pobocka pobocka) {
		this.pobocka = pobocka;
	}

	public String getZnacka() {
		return znacka;
	}

	public void setZnacka(String znacka) {
		this.znacka = znacka;
	}

	public Integer getVykonnost() {
		return vykonnost;
	}

	public void setVykonnost(Integer vykonnost) {
		this.vykonnost = vykonnost;
	}

	public Integer getVelikost() {
		return velikost;
	}

	public void setVelikost(Integer velikost) {
		this.velikost = velikost;
	}

	public Integer getKapacita() {
		return kapacita;
	}

	public void setKapacita(Integer kapacita) {
		this.kapacita = kapacita;
	}
	
	public Set<Vybava> getVybava() {
		return vybava;
	}

	public void setVybava(Set<Vybava> vybava) {
		this.vybava = vybava;
	}
}