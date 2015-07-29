package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import entities.Klient;

public class KlientDao extends AbstractDao implements GenericDao<Klient> {

	public void add(Klient item) {
		Session s = getSf().openSession();
		Transaction t = s.beginTransaction();
		s.persist(item);
		t.commit();
		s.close();
	}

	public List<Klient> showAll() {
		List<Klient> clients = new ArrayList<Klient>();

		Session s = getSf().openSession();
		Transaction t = s.beginTransaction();

		Query q = s.createQuery("SELECT k FROM Klient k");
		Iterator<Klient> result = q.iterate();
		while (result.hasNext()) {
			clients.add(result.next());
		}

		t.commit();
		s.close();
		return clients;
	}

	public Klient showOne(Integer id) {
		Klient k = new Klient();
		Session s = getSf().openSession();
		Transaction t = s.beginTransaction();
		k = (Klient) s.get(Klient.class, id);
		t.commit();
		s.close();
		return k;
	}

	public void update(Integer id, Klient data) {
		Session s = getSf().openSession();
		Transaction t = s.beginTransaction();
		Klient temp = (Klient) s.get(Klient.class, id);
		temp.setJmeno(data.getJmeno());
		t.commit();
		s.close();
	}

	public void delete(Integer id) {
		Session s = getSf().openSession();
		Transaction t = s.beginTransaction();
		Query q = s.createQuery("DELETE Klient k WHERE k.id=:id")
				.setParameter("id", id);
		q.executeUpdate();
		t.commit();
		s.close();
	}

}
