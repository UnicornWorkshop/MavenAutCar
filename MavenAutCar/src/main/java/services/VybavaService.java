package services;

import java.util.List;

import org.springframework.stereotype.Component;

import entities.Vybava;

@Component
public class VybavaService extends AbstractService<Vybava> implements GenericService<Vybava> {
	
	@Override
	public void add(Vybava item) {
		getDao().insert(item);
	}

	@Override
	public List<Vybava> all() {
		return getDao().getAll();
	}

	@Override
	public Vybava update(Integer id, Vybava item) {
		return getDao().update(id, item);
	}

	@Override
	public void delete(Integer id) {
		getDao().delete(id);
	}
}
