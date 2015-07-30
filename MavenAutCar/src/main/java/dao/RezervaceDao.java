package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import entities.Rezervace;
import entities.Rezervace;

@Component
public class RezervaceDao extends AbstractDao implements GenericDao<Rezervace> {

	public List<Rezervace> getAll() {
		List<Rezervace> items = new ArrayList<>();
		createSession();
		Transaction t = (Transaction) getSession().beginTransaction();
		Query q = getSession().createQuery("SELECT k FROM Rezervace k");
		Iterator<Rezervace> result = q.iterate();
		while (result.hasNext()) {
			items.add(result.next());
		}
		t.commit();
		closeSession();
		return items;
	}

	@Override
	public Rezervace get(Integer id) {
		createSession();
		Rezervace result = (Rezervace) getSession().get(Rezervace.class, id);
		closeSession();
		return result;
	}

	@Override
	public void insert(Rezervace item) {
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
		Query q = getSession().createQuery("DELETE Rezervace k WHERE k.id=:id").setParameter(
				"id", id);
		q.executeUpdate();
		t.commit();
		closeSession();
	}

	@Override
	public Rezervace update(Integer id, Rezervace item) {
		createSession();
		Transaction t = (Transaction) getSession().beginTransaction();
		Rezervace temp = (Rezervace) getSession().get(Rezervace.class, id);
		temp.setAuto(item.getAuto());
		temp.setDatum_do(item.getDatum_od());
		temp.setDatum_od(item.getDatum_od());
		temp.setKlient(item.getKlient());
		temp.setPobocka_do(item.getPobocka_do());
		temp.setPobocka_z(item.getPobocka_z());
		t.commit();
		closeSession();
		return temp;
	}
}
