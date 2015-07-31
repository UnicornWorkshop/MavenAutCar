package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import entities.Auto;
import entities.Pobocka;

@Component
public class PobockaDao extends AbstractDao implements IPobockaDao {

	@Override
	public Set<Auto> getCars(Integer id) {
		createSession();
		//Transaction t = (Transaction) getSession().beginTransaction();
		Pobocka pobocka = (Pobocka) getSession().get(Pobocka.class, id);
		Set<Auto> cars = pobocka.getAuta();
		//t.commit();
		closeSession();
		return cars;
	}
	
	@Override
	public List<Pobocka> getAll() {
		List<Pobocka> items = new ArrayList<>();
		createSession();
		Transaction t = (Transaction) getSession().beginTransaction();
		Query q = getSession().createQuery("SELECT k FROM Pobocka k");
		Iterator<Pobocka> result = q.iterate();
		while (result.hasNext()) {
			items.add(result.next());
		}
		t.commit();
		closeSession();
		return items;
	}

	@Override
	public Pobocka get(Integer id) {
		createSession();
		Pobocka result = (Pobocka) getSession().get(Pobocka.class, id);
		closeSession();
		return result;
	}

	@Override
	public void insert(Pobocka item) {
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
		Query q = getSession().createQuery("DELETE Pobocka k WHERE k.id=:id").setParameter(
				"id", id);
		q.executeUpdate();
		t.commit();
		closeSession();
	}

	@Override
	public Pobocka update(Integer id, Pobocka item) {
		createSession();
		Transaction t = (Transaction) getSession().beginTransaction();
		Pobocka temp = (Pobocka) getSession().get(Pobocka.class, id);
		//pokud zaznam neexistuje
		if(temp == null) {
			return null;
		}
		temp.setMesto(item.getMesto());
		t.commit();
		closeSession();
		return temp;
	}
}
