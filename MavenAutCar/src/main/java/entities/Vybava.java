package entities;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;  
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Vybava {
	@Id  
    @GeneratedValue
	private Integer id;
	private String nazev;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "Auto_Vybava",
			joinColumns={@JoinColumn(name="Auto_id")}, 
            inverseJoinColumns={@JoinColumn(name="Vybava_id")})
	private Set<Auto> auta;
	
	public void setId(Integer id) {
		this.id = id;
	}

	public void setAuta(Set<Auto> auta) {
		this.auta = auta;
	}

	public Vybava(){
		
	}
	
	public Vybava(String nazev) {
		super();
		this.nazev = nazev;
	}
	
	public Integer getId() {
		return id;
	}	
	public String getNazev() {
		return nazev;
	}
	public void setNazev(String nazev) {
		this.nazev = nazev;
	}
	public Set<Auto> getAuta() {
		return auta;
	}
}
