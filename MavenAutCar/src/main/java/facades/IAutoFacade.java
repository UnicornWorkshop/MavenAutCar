package facades;

import java.util.Set;

import entities.Auto;
import entities.Vybava;

public interface IAutoFacade extends GenericFacade<Auto> {
	
	public Set<Vybava> getEquipment(Integer id);

}
