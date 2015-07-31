package facades;

import java.util.List;

import org.springframework.stereotype.Component;

import entities.Rezervace;

@Component
public class RezervaceFacade extends AbstractFacade<Rezervace>implements GenericFacade<Rezervace> {
	
	@Override
	public Rezervace add(Rezervace item) {
		return getService().add(item);	
	}

	@Override
	public List<Rezervace> all() {
		return getService().all();
	}

	@Override
	public Rezervace update(Integer id, Rezervace item) {
		return getService().update(id, item);
	}

	@Override
	public void delete(Integer id) {
		getService().delete(id);
	}

}
