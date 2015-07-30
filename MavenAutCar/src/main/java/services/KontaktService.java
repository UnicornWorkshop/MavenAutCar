package services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EnumType;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import entities.Auto;
import entities.Klient;
import entities.Kontakt;
import entities.Kontakt;

@Component
public class KontaktService extends AbstractService implements GenericService<Kontakt> {

	@Override
	public void add(Kontakt item) {
		getDao().insert(item);
	}

	@Override
	public List<Kontakt> all() {
		return getDao().getAll();
	}

	@Override
	public Kontakt update(Integer id, Kontakt data) {
		Kontakt item = new Kontakt();
		item = (Kontakt) getDao().get(id);
		item.setKlient(data.getKlient());
		item.setTyp(data.getTypEnum());
		item.setData(data.getData());
		return item;	
	}

	@Override
	public void delete(Integer id) {
		getDao().delete(id);
	}
}
