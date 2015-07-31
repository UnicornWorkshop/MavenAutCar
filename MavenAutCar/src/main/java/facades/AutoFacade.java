package facades;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import entities.Auto;
import entities.Vybava;
import services.IAutoService;

@Component
public class AutoFacade extends AbstractFacade<Auto> implements IAutoFacade {
	
	@Autowired
	private IAutoService autoService;
	
	@Override
	public Set<Vybava> getEquipment(Integer id) {
		return autoService.getEquipment(id);
	}
	
	@Override
	public Auto add(Auto item) {		
		return getService().add(item);
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
