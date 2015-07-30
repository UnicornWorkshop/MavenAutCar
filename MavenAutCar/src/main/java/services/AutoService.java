package services;

import java.util.List;

import org.springframework.stereotype.Component;

import entities.Auto;

@Component
public class AutoService extends AbstractService<Auto> implements GenericService<Auto> {

	public void add(Auto item) {
		getDao().insert(item);
	}

	@Override
	public List<Auto> all() {
		return getDao().getAll();
	}

	@Override
	public Auto update(Integer id, Auto item) {
		return getDao().update(id, item);
	}

	@Override
	public void delete(Integer id) {
		getDao().delete(id);
	}
}
