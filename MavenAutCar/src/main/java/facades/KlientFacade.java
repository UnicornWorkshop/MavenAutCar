package facades;

import java.util.List;

import org.springframework.stereotype.Component;

import entities.Klient;

@Component
public class KlientFacade extends AbstractFacade<Klient>implements GenericFacade<Klient> {

	@Override
	public Klient add(Klient item) {
		return getService().add(item);
	}

	@Override
	public List<Klient> all() {
		return getService().all();
	}

	@Override
	public Klient update(Integer id, Klient item) {
		return getService().update(id, item);
	}

	@Override
	public void delete(Integer id) {
		getService().delete(id);
	}
}
