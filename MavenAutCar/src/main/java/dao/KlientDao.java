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

	private SessionFactory sf = new Configuration().configure()
			.buildSessionFactory();

	public void setSessionFactory(SessionFactory sf) {
		this.sf = sf;
	}

	public void add(Klient k) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.persist(k);
		t.commit();
		s.close();

		System.out.println("Client: " + k.getJmeno());
	}

	public List<Klient> showAll() {
		List<Klient> clients = new ArrayList<Klient>();

		Session s = sf.openSession();
		Transaction t = s.beginTransaction();

		Query q = s.createQuery("SELECT k FROM Klient k");
		Iterator<Klient> vysledek = q.iterate();
		while (vysledek.hasNext()) {
			clients.add(vysledek.next());
		}

		t.commit();
		s.close();
		return clients;
	}

	public Klient showOne(Integer id) {
		Klient k = new Klient();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		k = (Klient) s.get(Klient.class, id);
		t.commit();
		s.close();
		return k;
	}

	public void update(Integer id, Klient k) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Klient k2 = (Klient) s.get(Klient.class, id);
		k2.setJmeno(k.getJmeno());
		t.commit();
		s.close();
	}

	public void delete(Integer id) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		Query q = s.createQuery("DELETE Klient k WHERE k.id=:id")
				.setParameter("id", id);
		t.commit();
		s.close();
	}

}
