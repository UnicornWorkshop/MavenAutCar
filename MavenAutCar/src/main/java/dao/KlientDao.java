package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entities.Klient;

public class KlientDao {
	
	private SessionFactory sf = new Configuration().configure().buildSessionFactory();
    
    public void setSessionFactory(SessionFactory sf){
        this.sf = sf;
    }
    
    public void addKlient(Klient k) {
    	Session s = sf.openSession();
		Transaction t = s.beginTransaction();
//		Session session = this.sf.getCurrentSession();
//      session.persist(k);
		s.persist(k);
		t.commit();
		s.close();
		
        System.out.println("Client: " + k.getJmeno());
    }
	
}
