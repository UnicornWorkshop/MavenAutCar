package controllers;

import org.springframework.beans.factory.annotation.Autowired;

import services.GenericDao;

public abstract class AbstractController<T>{
	
	@Autowired
	private GenericDao<T> dao;

	public GenericDao<T> getDao() {
		return dao;
	}

}
