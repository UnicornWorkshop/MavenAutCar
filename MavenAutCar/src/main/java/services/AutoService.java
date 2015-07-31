package services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.GenericDao;
import dao.IAutoDao;
import entities.Auto;
import entities.Pobocka;
import entities.Vybava;

@Component
public class AutoService extends AbstractService<Auto> implements IAutoService {

	@Autowired
	private GenericDao<Pobocka> pobockaDao;
	
	@Autowired
	private IAutoDao autoDao;	

	@Override
	public Set<Vybava> getEquipment(Integer id) {
		return autoDao.getEquipment(id);
	}	
		
	@Override
	public Auto add(Auto item) {
		//rozsekat na auto a pobocku a nejdriv vlozit pobocku
		pobockaDao.insert(item.getPobocka());
				
		getDao().insert(item);
		return item;
	}

	@Override
	public List<Auto> all() {
		return getDao().getAll();
	}

	@Override
	public Auto update(Integer id, Auto item) {
		return getDao().update(id, item);
	}

	@Override
	public void delete(Integer id) {
		getDao().delete(id);
	}

}
