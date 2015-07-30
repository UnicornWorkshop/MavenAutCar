package services;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractService {

	@Autowired
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

}
