package dao;

import java.util.Set;

import entities.Auto;
import entities.Vybava;

public interface IAutoDao extends GenericDao<Auto>{
	
	public Set<Vybava> getEquipment(Integer id);

}
