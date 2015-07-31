package dao;

import java.util.Set;

import entities.Auto;
import entities.Pobocka;

public interface IPobockaDao extends GenericDao<Pobocka> {
	
	public Set<Auto> getCars(Integer id);

}
