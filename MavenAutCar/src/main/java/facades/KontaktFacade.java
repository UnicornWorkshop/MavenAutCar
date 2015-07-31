package facades;

import java.util.List;

import org.springframework.stereotype.Component;

import entities.Kontakt;

@Component
public class KontaktFacade extends AbstractFacade<Kontakt>implements GenericFacade<Kontakt> {
	
	@Override
	public Kontakt add(Kontakt item) {
		return getService().add(item);	
	}

	@Override
	public List<Kontakt> all() {
		return getService().all();
	}

	@Override
	public Kontakt update(Integer id, Kontakt item) {
		return getService().update(id, item);
	}

	@Override
	public void delete(Integer id) {
		getService().delete(id);		
	}

}
