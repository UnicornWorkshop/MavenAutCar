package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.Klient;

public class KlientDao {
	
	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    public void addKlient(Klient k) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(k);
        System.out.println("Client: " + k.getJmeno());
    }
	
}
