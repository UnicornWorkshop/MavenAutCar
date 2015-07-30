package services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import entities.Pobocka;

@Component
public class PobockaService extends AbstractService implements GenericService<Pobocka> {

	@Override
	public void add(Pobocka item) {
		getDao().insert(item);
	}

	@Override
	public List<Pobocka> all() {
		return getDao().getAll();
	}

	@Override
	public Pobocka update(Integer id, Pobocka data) {
		Pobocka item = new Pobocka();
		item = (Pobocka) getDao().get(id);
		item.setMesto(data.getMesto());
		return item;
	}

	@Override
	public void delete(Integer id) {
		getDao().delete(id);
	}
}
