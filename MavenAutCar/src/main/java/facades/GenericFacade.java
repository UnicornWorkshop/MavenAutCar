package facades;

import java.util.List;

public interface GenericFacade<T> {
	
	public T add(T item);
	public List<T> all();
	public T update(Integer id, T item);
	public void delete(Integer id);

}
