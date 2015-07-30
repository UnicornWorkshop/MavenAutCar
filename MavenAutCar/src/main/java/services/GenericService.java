package services;

import java.util.List;

public interface GenericService<T> {
	
	public void add(T item);
	public List<T> all();
	public void update(Integer id, T data);
	public void delete(Integer id);
	
}
