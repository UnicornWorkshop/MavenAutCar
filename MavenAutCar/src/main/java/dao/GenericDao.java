package dao;

import java.util.List;

public interface GenericDao<T> {
	
	public List<T> getAll();
	public T get(Integer id);
	public void insert(T item);
	public void delete(Integer id);

}
