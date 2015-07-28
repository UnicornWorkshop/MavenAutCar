package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entities.Klient;

public class KlientDao implements GenericDao<Klient> {
	
	private SessionFactory sf = new Configuration().configure().buildSessionFactory();
    
    public void setSessionFactory(SessionFactory sf){
        this.sf = sf;
    }
    
    @Override
    public void add(Klient k) {
    	Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.persist(k);
		t.commit();
		s.close();
		
        System.out.println("Client: " + k.getJmeno());
    }
    
    @Override
    public List<Klient> showAll() {
    	List<Klient> clients = new ArrayList<>();
    	
    	Session s = sf.openSession();
		Transaction t = s.beginTransaction();

		Query q = s.createQuery("SELECT k FROM Klient k");
		Iterator<Klient> vysledek = q.iterate();
		while(vysledek.hasNext()) {
			clients.add(vysledek.next());
		}				
		
		t.commit();
		s.close(); 	
		return clients;
    }
    
    @Override
    public Klient showOne(Integer id) {
    	return null;
    }
    
    @Override
    public void update(Integer id) {
    	
    }
    
    @Override
    public void delete(Integer id) {
    	
    }
	
}
