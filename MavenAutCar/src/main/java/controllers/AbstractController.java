package controllers;

import org.springframework.beans.factory.annotation.Autowired;

import facades.GenericFacade;
import services.GenericService;

//import org.springframework.beans.factory.annotation.Autowired;

//import services.GenericService;

public abstract class AbstractController<T>{
	
	@Autowired
	private GenericService<T> service;
	@Autowired
	private GenericFacade<T> facade;

	public GenericService<T> getService() {
		return service;
	}
	
	public GenericFacade<T> getFacade() {
		return facade;
	}	
	
	/*@Autowired
	private GenericService<T> dao;

	public GenericService<T> getDao() {
		return dao;
	}*/

}
