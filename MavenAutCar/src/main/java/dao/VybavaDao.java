package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import entities.Vybava;
import entities.Vybava;

@Component
public class VybavaDao extends AbstractDao implements GenericDao<Vybava> {

	public List<Vybava> getAll() {
		List<Vybava> items = new ArrayList<>();
		createSession();
		Transaction t = (Transaction) getSession().beginTransaction();
		Query q = getSession().createQuery("SELECT k FROM Vybava k");
		Iterator<Vybava> result = q.iterate();
		while (result.hasNext()) {
			items.add(result.next());
		}
		t.commit();
		closeSession();
		return items;
	}

	@Override
	public Vybava get(Integer id) {
		createSession();
		Vybava result = (Vybava) getSession().get(Vybava.class, id);
		closeSession();
		return result;
	}

	@Override
	public void insert(Vybava item) {
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
		Query q = getSession().createQuery("DELETE Vybava k WHERE k.id=:id").setParameter(
				"id", id);
		q.executeUpdate();
		t.commit();
		closeSession();
	}

	@Override
	public Vybava update(Integer id, Vybava item) {
		createSession();
		Transaction t = (Transaction) getSession().beginTransaction();
		Vybava temp = (Vybava) getSession().get(Vybava.class, id);
		temp.setNazev(item.getNazev());
		t.commit();
		closeSession();
		return temp;
	}
}
