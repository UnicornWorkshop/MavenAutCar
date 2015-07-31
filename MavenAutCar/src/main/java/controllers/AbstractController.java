package controllers;

import org.springframework.beans.factory.annotation.Autowired;

import facades.GenericFacade;

public abstract class AbstractController<T>{

	@Autowired
	private GenericFacade<T> facade;
	
	public GenericFacade<T> getFacade() {
		return facade;
	}	

}
