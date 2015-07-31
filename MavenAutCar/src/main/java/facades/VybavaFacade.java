package facades;

import java.util.List;

import org.springframework.stereotype.Component;

import entities.Vybava;

@Component
public class VybavaFacade extends AbstractFacade<Vybava>implements GenericFacade<Vybava> {
	
	@Override
	public void add(Vybava item) {
		getService().add(item);		
	}

	@Override
	public List<Vybava> all() {
		return getService().all();
	}

	@Override
	public Vybava update(Integer id, Vybava item) {
		return getService().update(id, item);
	}

	@Override
	public void delete(Integer id) {
		getService().delete(id);
	}

}
