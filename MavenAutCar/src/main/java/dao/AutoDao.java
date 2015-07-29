package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Auto;
import entities.Klient;

public class AutoDao extends AbstractDao implements GenericDao<Auto> {

	@Override
	public void add(Auto item) {
		Session s = getSf().openSession();
		Transaction t = s.beginTransaction();
		s.persist(item);
		t.commit();
		s.close();
	}

	@Override
	public Auto showOne(Integer id) {
		Auto a = new Auto();
		Session s = getSf().openSession();
		Transaction t = s.beginTransaction();
		a = (Auto) s.get(Auto.class, id);
		t.commit();
		s.close();
		return a;
	}

	@Override
	public List<Auto> showAll() {
		List<Auto> cars = new ArrayList<Auto>();

		Session s = getSf().openSession();
		Transaction t = s.beginTransaction();

		Query q = s.createQuery("SELECT a FROM Auto a");
		Iterator<Auto> result = q.iterate();
		while (result.hasNext()) {
			cars.add(result.next());
		}

		t.commit();
		s.close();
		return cars;
	}

	@Override
	public void update(Integer id, Auto data) {
		Session s = getSf().openSession();
		Transaction t = s.beginTransaction();
		Auto temp = (Auto) s.get(Auto.class, id);
		temp.setKapacita(data.getKapacita());
		temp.setPobocka(data.getPobocka());
		temp.setVelikost(data.getVelikost());
		temp.setVybava(data.getVybava());
		temp.setVykonnost(data.getVykonnost());
		temp.setZnacka(data.getZnacka());
		t.commit();
		s.close();
	}

	@Override
	public void delete(Integer id) {
		Session s = getSf().openSession();
		Transaction t = s.beginTransaction();
		Query q = s.createQuery("DELETE Auto a WHERE a.id=:id")
				.setParameter("id", id);
		q.executeUpdate();
		t.commit();
		s.close();
	}
}