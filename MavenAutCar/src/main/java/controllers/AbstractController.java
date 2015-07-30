package controllers;

import org.springframework.beans.factory.annotation.Autowired;

import entities.Auto;
import services.GenericService;

//import org.springframework.beans.factory.annotation.Autowired;

//import services.GenericService;

public abstract class AbstractController<T>{
	
	@Autowired
	private GenericService<T> service;

	public GenericService<T> getService() {
		return service;
	}
	
	
	
	/*@Autowired
	private GenericService<T> dao;

	public GenericService<T> getDao() {
		return dao;
	}*/

}
