package entities;

import java.util.Date;
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.Id;  
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Rezervace {
	@Id  
    @GeneratedValue
	private Integer id;
	@ManyToOne
	private Klient klient;
	@ManyToOne
	private Auto auto;
	@ManyToOne
	private Pobocka pobocka_z;
	@ManyToOne
	private Pobocka pobocka_do;
	@Temporal(TemporalType.DATE)
	private Date datum_od;
	@Temporal(TemporalType.DATE)
	private Date datum_do;
		
	public void setId(Integer id) {
		this.id = id;
	}

	public Rezervace() {
		
	}
	
	public Rezervace(Klient klient, Auto auto, Pobocka pobocka_z, Pobocka pobocka_do, Date datum_od,
			Date datum_do) {
		super();
		this.klient = klient;
		this.auto = auto;
		this.pobocka_z = pobocka_z;
		this.pobocka_do = pobocka_do;
		this.datum_od = datum_od;
		this.datum_do = datum_do;
	}
	
	public Integer getId() {
		return id;
	}
	public Date getDatum_od() {
		return datum_od;
	}
	public void setDatum_od(Date datum_od) {
		this.datum_od = datum_od;
	}
	public Date getDatum_do() {
		return datum_do;
	}
	public void setDatum_do(Date datum_do) {
		this.datum_do = datum_do;
	}
	public Klient getKlient() {
		return klient;
	}
	public void setKlient(Klient klient) {
		this.klient = klient;
	}
	public Auto getAuto() {
		return auto;
	}
	public void setAuto(Auto auto) {
		this.auto = auto;
	}
	public Pobocka getPobocka_z() {
		return pobocka_z;
	}
	public void setPobocka_z(Pobocka pobocka_z) {
		this.pobocka_z = pobocka_z;
	}
	public Pobocka getPobocka_do() {
		return pobocka_do;
	}
	public void setPobocka_do(Pobocka pobocka_do) {
		this.pobocka_do = pobocka_do;
	}
}
