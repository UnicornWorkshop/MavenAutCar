package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import entities.Klient;

@Component
public class KlientDao extends AbstractDao implements GenericDao<Klient> {

	public List<Klient> getAll() {
		List<Klient> items = new ArrayList<>();
		createSession();
		Transaction t = (Transaction) getSession().beginTransaction();
		Query q = getSession().createQuery("SELECT k FROM Klient k");
		Iterator<Klient> result = q.iterate();
		while (result.hasNext()) {
			items.add(result.next());
		}
		t.commit();
		//closeSession();
		return items;
	}

	@Override
	public Klient get(Integer id) {
		createSession();
		Klient result = (Klient) getSession().get(Klient.class, id);
		//closeSession();
		return result;
	}

	@Override
	public void insert(Klient item) {
		createSession();
		Transaction t = getSession().beginTransaction();	
		/*
		 * kontrola, jestli neposilam obsazene id
		 * - to by znamenalo ze byl insert zavolan pri vkladani
		 *   prvku, ktery na toto odkazuje pres cizi klic
		 */
		//pokud bylo id poslano v json
		Integer id = item.getId();
		Klient result = null;
		
		if(id != null) {
			result = (Klient) getSession().get(Klient.class, id);
		}
		//pokud byl nalezen klient
		if(result != null) {
			return;
		}

		item.setId(null);
		getSession().persist(item);
		t.commit();
		//closeSession();
	}

	@Override
	public void delete(Integer id) {
		createSession();
		Transaction t = (Transaction) getSession().beginTransaction();
		//Query q = getSession().createQuery("DELETE Klient k WHERE k.id=:id").setParameter("id", id);
		//q.executeUpdate();
		Klient k = (Klient) getSession().get(Klient.class, id);
		getSession().delete(k);
		t.commit();
		//closeSession();
	}

	@Override
	public Klient update(Integer id, Klient item) {
		createSession();
		Transaction t = (Transaction) getSession().beginTransaction();
		Klient temp = (Klient) getSession().get(Klient.class, id);
		// pokud zaznam neexistuje
		if (temp == null) {
			return null;
		}
		temp.setJmeno(item.getJmeno());
		t.commit();
		//closeSession();
		return temp;
	}
}
