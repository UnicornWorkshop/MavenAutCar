package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import entities.Kontakt;

@Component
public class KontaktDao extends AbstractDao implements GenericDao<Kontakt> {

	public List<Kontakt> getAll() {
		createSession();
		List<Kontakt> items = new ArrayList<>();
		Criteria c = getSession().createCriteria(Kontakt.class);
		items = c.list();
		closeSession();
		return items;
	}

	@Override
	public Kontakt get(Integer id) {
		createSession();
		Kontakt item = new Kontakt();
		//k = (Klient) session.load(Klient.class, id);
		Criteria c = getSession().createCriteria(Kontakt.class);
		c.add(Restrictions.eq("id", id));
		item = (Kontakt) c.uniqueResult();
		closeSession();
		return item;
	}

	@Override
	public void insert(Kontakt item) {
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
