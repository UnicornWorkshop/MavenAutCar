package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import entities.Rezervace;

@Component
public class RezervaceDao extends AbstractDao implements GenericDao<Rezervace> {

	public List<Rezervace> getAll() {
		createSession();
		List<Rezervace> items = new ArrayList<>();
		Criteria c = getSession().createCriteria(Rezervace.class);
		items = c.list();
		closeSession();
		return items;
	}

	@Override
	public Rezervace get(Integer id) {
		createSession();
		Rezervace item = new Rezervace();
		//k = (Klient) session.load(Klient.class, id);
		Criteria c = getSession().createCriteria(Rezervace.class);
		c.add(Restrictions.eq("id", id));
		item = (Rezervace) c.uniqueResult();
		closeSession();
		return item;
	}

	@Override
	public void insert(Rezervace item) {
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
