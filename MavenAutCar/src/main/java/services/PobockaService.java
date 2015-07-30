package services;

import java.util.List;

import org.springframework.stereotype.Component;

import entities.Pobocka;

@Component
public class PobockaService extends AbstractService<Pobocka> implements GenericService<Pobocka> {

	@Override
	public void add(Pobocka item) {
		getDao().insert(item);
	}

	@Override
	public List<Pobocka> all() {
		return getDao().getAll();
	}

	@Override
	public Pobocka update(Integer id, Pobocka item) {
		return getDao().update(id, item);
	}

	@Override
	public void delete(Integer id) {
		getDao().delete(id);
	}
}
