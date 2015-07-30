package services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import entities.Vybava;
import entities.Rezervace;
import entities.Vybava;

@Component
public class VybavaService extends AbstractService implements GenericService<Vybava> {
	
	@Override
	public void add(Vybava item) {
		getDao().insert(item);
	}

	@Override
	public List<Vybava> all() {
		return getDao().getAll();
	}

	@Override
	public Vybava update(Integer id, Vybava data) {
		Vybava item = new Vybava();
		item = (Vybava) getDao().get(id);
		item.setNazev(data.getNazev());
		return item;
	}

	@Override
	public void delete(Integer id) {
		getDao().delete(id);
	}
}
