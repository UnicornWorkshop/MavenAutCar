package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Transaction;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import entities.Kontakt;

@Component
public class KontaktDao extends AbstractDao implements GenericDao<Kontakt> {

	public List<Kontakt> getAll() {
		List<Kontakt> items = new ArrayList<>();
		createSession();
		Transaction t = (Transaction) getSession().beginTransaction();
		Query q = getSession().createQuery("SELECT k FROM Kontakt k");
		Iterator<Kontakt> result = q.iterate();
		while (result.hasNext()) {
			items.add(result.next());
		}
		t.commit();
		closeSession();
		return items;
	}

	@Override
	public Kontakt get(Integer id) {
		createSession();
		Kontakt result = (Kontakt) getSession().get(Kontakt.class, id);
		closeSession();
		return result;
	}

	@Override
	public void insert(Kontakt item) {
		createSession();
		Transaction t = getSession().beginTransaction();
		getSession().persist(item);
		t.commit();
		closeSession();	
	}

	@Override
	public void delete(Integer id) {
		createSession();
		Transaction t = (Transaction) getSession().beginTransaction();
		Query q = getSession().createQuery("DELETE Kontakt k WHERE k.id=:id").setParameter(
				"id", id);
		q.executeUpdate();
		t.commit();
		closeSession();
	}

	@Override
	public Kontakt update(Integer id, Kontakt item) {
		createSession();
		Transaction t = (Transaction) getSession().beginTransaction();
		Kontakt temp = (Kontakt) getSession().get(Kontakt.class, id);
		temp.setKlient(item.getKlient());
		temp.setTyp(item.getTypEnum());
		temp.setData(item.getData());
		t.commit();
		closeSession();
		return temp;
	}
}
