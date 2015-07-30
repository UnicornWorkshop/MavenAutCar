package dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao {
	
	@Autowired
	Session session;

	public Session getSession() {
		return session;
	}
		
}
