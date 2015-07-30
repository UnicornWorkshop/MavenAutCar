package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao {
	
	@Autowired
	private SessionFactory sf;
	private Session session;

	public SessionFactory getSf() {
		return sf;
	}
		
	public void createSession() {
		session = sf.openSession();
	}
	
	public Session getSession() {
		return session;
	}
	
	public void closeSession() {
		session.close();
	}
		
}
