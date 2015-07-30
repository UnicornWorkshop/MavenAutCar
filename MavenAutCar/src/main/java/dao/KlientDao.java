package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import entities.Klient;

public class KlientDao extends AbstractDao implements GenericDao<Klient> {
	
	public List<Klient> getAll() {
		createSession();
		List<Klient> clients = new ArrayList<>();
		Criteria c = getSession().createCriteria(Klient.class);
		clients = c.list();
		closeSession();
		return clients;
	}

	@Override
	public Klient get(Integer id) {
		createSession();
		Klient k = new Klient();
		//k = (Klient) session.load(Klient.class, id);
		Criteria c = getSession().createCriteria(Klient.class);
		c.add(Restrictions.eq("id", id));
		k = (Klient) c.uniqueResult();
		closeSession();
		return k;
	}

	@Override
	public void insert(Klient item) {
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
