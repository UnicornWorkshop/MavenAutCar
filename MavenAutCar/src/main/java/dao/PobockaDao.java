package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import entities.Kontakt;
import entities.Pobocka;

@Component
public class PobockaDao extends AbstractDao implements GenericDao<Pobocka> {

	public List<Pobocka> getAll() {
		createSession();
		List<Pobocka> items = new ArrayList<>();
		Criteria c = getSession().createCriteria(Pobocka.class);
		items = c.list();
		closeSession();
		return items;
	}

	@Override
	public Pobocka get(Integer id) {
		createSession();
		Pobocka item = new Pobocka();
		//k = (Klient) session.load(Klient.class, id);
		Criteria c = getSession().createCriteria(Pobocka.class);
		c.add(Restrictions.eq("id", id));
		item = (Pobocka) c.uniqueResult();
		closeSession();
		return item;
	}

	@Override
	public void insert(Pobocka item) {
		createSession();
		getSession().persist(item);
		closeSession();
	}

	@Override
	public void delete(Integer id) {
		createSession();
		getSession().delete(this.get(id));
		closeSession();
	}
}
