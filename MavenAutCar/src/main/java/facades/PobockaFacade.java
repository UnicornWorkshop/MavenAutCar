package facades;

import java.util.List;

import org.springframework.stereotype.Component;

import entities.Pobocka;

@Component
public class PobockaFacade extends AbstractFacade<Pobocka>implements GenericFacade<Pobocka> {
	
	@Override
	public Pobocka add(Pobocka item) {
		return getService().add(item);
	}

	@Override
	public List<Pobocka> all() {
		return getService().all();
	}

	@Override
	public Pobocka update(Integer id, Pobocka item) {
		return getService().update(id, item);
	}

	@Override
	public void delete(Integer id) {
		getService().delete(id);
	}

}
