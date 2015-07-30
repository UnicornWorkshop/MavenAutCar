package services;

import java.util.List;

import org.springframework.stereotype.Component;

import entities.Klient;

@Component
public class KlientService extends AbstractService<Klient> implements GenericService<Klient> {

	@Override
	public void add(Klient item) {
		getDao().insert(item);		
	}

	@Override
	public List<Klient> all() {
		return getDao().getAll();
	}

	@Override
	public Klient update(Integer id, Klient data) {
		Klient k = new Klient();
		k = (Klient) getDao().get(id);
		k.setJmeno(data.getJmeno());
		return k;		
	}

	@Override
	public void delete(Integer id) {
		getDao().delete(id);
	}

}
