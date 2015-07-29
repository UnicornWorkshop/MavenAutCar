package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EnumType;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Auto;
import entities.Kontakt;

public class KontaktDao extends AbstractDao implements GenericDao<Kontakt> {

	@Override
	public void add(Kontakt item) {
		Session s = getSf().openSession();
		Transaction t = s.beginTransaction();
		s.persist(item);
		t.commit();
		s.close();
	}

	@Override
	public Kontakt showOne(Integer id) {
		Kontakt k = new Kontakt();
		Session s = getSf().openSession();
		Transaction t = s.beginTransaction();
		k = (Kontakt) s.get(Kontakt.class, id);
		t.commit();
		s.close();
		return k;
	}

	@Override
	public List<Kontakt> showAll() {
		List<Kontakt> contacts = new ArrayList<Kontakt>();

		Session s = getSf().openSession();
		Transaction t = s.beginTransaction();

		Query q = s.createQuery("SELECT k FROM Kontakt k");
		Iterator<Kontakt> result = q.iterate();
		while (result.hasNext()) {
			contacts.add(result.next());
		}

		t.commit();
		s.close();
		return contacts;
	}

	@Override
	public Kontakt update(Integer id, Kontakt data) {
		Session s = getSf().openSession();
		Transaction t = s.beginTransaction();
		Kontakt temp = (Kontakt) s.get(Kontakt.class, id);
		temp.setKlient(data.getKlient());
		temp.setTyp((data.getTypEnum()));
		temp.setData(data.getData());
		t.commit();
		s.close();
		return temp;
	}

	@Override
	public void delete(Integer id) {
		Session s = getSf().openSession();
		Transaction t = s.beginTransaction();
		Query q = s.createQuery("DELETE Kontakt k WHERE k.id=:id")
				.setParameter("id", id);
		q.executeUpdate();
		t.commit();
		s.close();		
	}

}
