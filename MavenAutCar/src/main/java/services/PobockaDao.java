package services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import entities.Pobocka;

@Component
public class PobockaDao extends AbstractService implements GenericDao<Pobocka> {
	
	public void add(Pobocka p) {
		Session s = getSf().openSession();
		Transaction t = s.beginTransaction();
		s.persist(p);
		t.commit();
		s.close();

		System.out.println("Pobocka: " + p.getMesto());
	}

	public List<Pobocka> all() {
		List<Pobocka> pobocky = new ArrayList<>();

		Session s = getSf().openSession();
		Transaction t = s.beginTransaction();

		Query q = s.createQuery("SELECT p FROM Pobocka p");
		Iterator<Pobocka> vysledek = q.iterate();
		while (vysledek.hasNext()) {
			pobocky.add(vysledek.next());
		}

		t.commit();
		s.close();
		return pobocky;
	}

	public Pobocka showOne(Integer id) {
		Session s = getSf().openSession();
		Transaction t = s.beginTransaction();
		Pobocka p = (Pobocka) s.get(Pobocka.class, id);
		t.commit();
		s.close();
		return p;
	}

	public Pobocka update(Integer id, Pobocka data) {
		Session s = getSf().openSession();
		Transaction t = s.beginTransaction();
		Pobocka temp = (Pobocka) s.get(Pobocka.class, id);
		temp.setMesto(data.getMesto());
		t.commit();
		s.close();
		return temp;
	}

	public void delete(Integer id) {
		Session s = getSf().openSession();
		Transaction t = s.beginTransaction();
		Query q = s.createQuery("DELETE Pobocka p WHERE p.id=:id")
				.setParameter("id", id);
		q.executeUpdate();
		t.commit();
		s.close();
	}

}
