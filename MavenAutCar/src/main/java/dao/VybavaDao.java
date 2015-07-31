package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

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
		/*
		 * kontrola, jestli neposilam obsazene id
		 * - to by znamenalo ze byl insert zavolan pri vkladani
		 *   prvku, ktery na toto odkazuje pres cizi klic
		 */
		//pokud bylo id poslano v json
		Integer id = item.getId();
		Vybava result = null;
		
		if(id != null) {
			result = (Vybava) getSession().get(Vybava.class, id);
		}
		//pokud byl nalezen klient
		if(result != null) {
			return;
		}

		item.setId(null);
		getSession().persist(item);
		t.commit();
		closeSession();
	}

	@Override
	public void delete(Integer id) {
		createSession();
		Transaction t = (Transaction) getSession().beginTransaction();
		Query q = getSession().createQuery("DELETE Vybava k WHERE k.id=:id").setParameter("id", id);
		q.executeUpdate();
		t.commit();
		closeSession();
	}

	@Override
	public Vybava update(Integer id, Vybava item) {
		createSession();
		Transaction t = (Transaction) getSession().beginTransaction();
		Vybava temp = (Vybava) getSession().get(Vybava.class, id);
		// pokud zaznam neexistuje
		if (temp == null) {
			return null;
		}
		temp.setNazev(item.getNazev());
		t.commit();
		closeSession();
		return temp;
	}
}
