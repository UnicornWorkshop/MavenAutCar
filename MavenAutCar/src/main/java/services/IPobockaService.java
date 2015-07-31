package services;

import java.util.Set;

import entities.Auto;
import entities.Pobocka;

public interface IPobockaService extends GenericService<Pobocka> {

	public Set<Auto> getCars(Integer id);
	
}
