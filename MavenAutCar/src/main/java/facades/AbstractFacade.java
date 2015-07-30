package facades;

import org.springframework.beans.factory.annotation.Autowired;

import services.GenericService;

public abstract class AbstractFacade<T> {

	@Autowired
	private GenericService<T> service;

	public GenericService<T> getService() {
		return service;
	}
}
