package services;

import java.util.List;

public interface GenericService<T> {
	
	public void add(T item);
	public List<T> all();
	public T update(Integer id, T data);
	public void delete(Integer id);
	
}
