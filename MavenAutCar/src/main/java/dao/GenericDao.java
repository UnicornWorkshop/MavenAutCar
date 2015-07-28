package dao;

import java.util.List;

public interface GenericDao<T> {
	
	public void add(T item);
	public T showOne(Integer id);
	public List<T> showAll();
	public void update(Integer id, T data);
	public void delete(Integer id);
	
}
