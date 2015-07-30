package services;

import org.springframework.beans.factory.annotation.Autowired;

import dao.GenericDao;

public abstract class AbstractService<T> {

	@Autowired
	private GenericDao<T> dao;

	public GenericDao<T> getDao() {
		return dao;
	}

}
