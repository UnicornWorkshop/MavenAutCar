package dao;

import java.util.List;

import entities.Auto;
import entities.Klient;

public interface GenericDao<T> {
	
	public void add(T item);
	public T showOne(Integer id);
	public List<T> showAll();
	public T update(Integer id, T data);
	public void delete(Integer id);
	
}
