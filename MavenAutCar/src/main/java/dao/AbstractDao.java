package dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public abstract class AbstractDao {

	/*private SessionFactory sf = new Configuration().configure()
			.buildSessionFactory();*/
	
	@Resource
	private SessionFactory sf;

//	@Required
//	public void setSf(SessionFactory sf) {
//		this.sf = sf;
//	}
//
	public SessionFactory getSf() {
		return sf;
	}

}
