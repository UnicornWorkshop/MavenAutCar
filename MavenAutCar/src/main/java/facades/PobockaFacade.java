package facades;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import entities.Auto;
import entities.Pobocka;
import services.IPobockaService;

@Component
public class PobockaFacade extends AbstractFacade<Pobocka> implements IPobockaFacade {

	@Autowired
	private IPobockaService pobockaService;
	
	@Override
	public Set<Auto> getCars(Integer id) {
		return pobockaService.getCars(id);
	}

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
