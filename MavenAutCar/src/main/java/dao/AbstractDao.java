package dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class AbstractDao {
	
	private SessionFactory sf = new Configuration().configure()
			.buildSessionFactory();

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public SessionFactory getSf() {
		return sf;
	}
		
}