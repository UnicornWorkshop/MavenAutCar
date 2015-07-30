package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import entities.Auto;

@Component
public class AutoDao extends AbstractDao implements GenericDao<Auto> {
	
	@Override
	public Auto get(Integer id) {
		createSession();
		Auto result = (Auto) getSession().get(Auto.class, id);
		closeSession();
		return result;
	}

	@Override
	public void insert(Auto item) {
		createSession();
		Transaction t = getSession().beginTransaction();
		getSession().persist(item);
		t.commit();
		closeSession();	
	}

	@Override
	public List<Auto> getAll() {
		List<Auto> items = new ArrayList<Auto>();
		createSession();
		Transaction t = getSession().beginTransaction();
		Query q = getSession().createQuery("SELECT a FROM Auto a");
		Iterator<Auto> result = q.iterate();
		while (result.hasNext()) {
			items.add(result.next());
		}
		t.commit();
		closeSession();
		return items;		
	}

	@Override
	public void delete(Integer id) {
		createSession();
		Transaction t = getSession().beginTransaction();
		Query q = getSession().createQuery("DELETE Auto a WHERE a.id=:id").setParameter(
				"id", id);
		q.executeUpdate();
		t.commit();
		closeSession();		
	}

	@Override
	public Auto update(Integer id, Auto item) {
		createSession();
		Transaction t = getSession().beginTransaction();
		Auto temp = (Auto) getSession().get(Auto.class, id);
		temp.setKapacita(item.getKapacita());
		temp.setPobocka(item.getPobocka());
		temp.setVelikost(item.getVelikost());
		temp.setVybava(item.getVybava());
		temp.setVykonnost(item.getVykonnost());
		temp.setZnacka(item.getZnacka());
		t.commit();
		closeSession();
		return temp;
	}
	
}