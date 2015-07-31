package facades;

import java.util.List;

import org.springframework.stereotype.Component;

import entities.Auto;

@Component
public class AutoFacade extends AbstractFacade<Auto> implements GenericFacade<Auto> {
	
	@Override
	public void add(Auto item) {		
		getService().add(item);
	}

	@Override
	public List<Auto> all() {
		return getService().all();
	}

	@Override
	public Auto update(Integer id, Auto item) {
		return getService().update(id, item);
	}

	@Override
	public void delete(Integer id) {
		getService().delete(id);		
	}
	
}
