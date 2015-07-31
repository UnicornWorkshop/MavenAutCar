package facades;

import java.util.Set;

import entities.Auto;
import entities.Pobocka;

public interface IPobockaFacade extends GenericFacade<Pobocka> {
	
	public Set<Auto> getCars(Integer id);

}
