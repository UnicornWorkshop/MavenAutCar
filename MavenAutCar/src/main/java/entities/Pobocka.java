package entities;

import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.Id;

@Entity
public class Pobocka {
	@Id  
    @GeneratedValue
	private Integer id;
	private String mesto;
	
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
