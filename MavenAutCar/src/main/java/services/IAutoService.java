package services;

import java.util.Set;

import entities.Auto;
import entities.Vybava;

public interface IAutoService extends GenericService<Auto> {
	
	public Set<Vybava> getEquipment(Integer id);

}
