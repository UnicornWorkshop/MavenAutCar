package entities;

import java.util.Set;
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.Id;  
import javax.persistence.ManyToMany;

@Entity
public class Vybava {
	@Id  
    @GeneratedValue
	private Integer id;
	private String nazev;
	//@ManyToMany
	//private Set<Auto> auto;
	
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
	/*public Set<Auto> getAuto() {
		return auto;
	}
	public void setAuto(Set<Auto> auto) {
		this.auto = auto;
	}*/	
}
