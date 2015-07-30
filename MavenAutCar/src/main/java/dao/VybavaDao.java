package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import entities.Vybava;

@Component
public class VybavaDao extends AbstractDao implements GenericDao<Vybava> {

	public List<Vybava> getAll() {
		createSession();
		List<Vybava> items = new ArrayList<>();
		Criteria c = getSession().createCriteria(Vybava.class);
		items = c.list();
		closeSession();
		return items;
	}

	@Override
	public Vybava get(Integer id) {
		createSession();
		Vybava item = new Vybava();
		//k = (Klient) session.load(Klient.class, id);
		Criteria c = getSession().createCriteria(Vybava.class);
		c.add(Restrictions.eq("id", id));
		item = (Vybava) c.uniqueResult();
		closeSession();
		return item;
	}

	@Override
	public void insert(Vybava item) {
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
