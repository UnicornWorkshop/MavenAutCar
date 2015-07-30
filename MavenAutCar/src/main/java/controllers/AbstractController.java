package controllers;

import org.springframework.beans.factory.annotation.Autowired;

import services.GenericService;

public abstract class AbstractController<T>{
	
	@Autowired
	private GenericService<T> dao;

	public GenericService<T> getDao() {
		return dao;
	}

}
