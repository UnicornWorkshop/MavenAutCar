package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.GenericDao;
import entities.Auto;
import entities.Pobocka;

@Component
public class AutoService extends AbstractService<Auto> implements GenericService<Auto> {

	@Autowired
	private GenericDao<Pobocka> pobockaDao;
		
	public void add(Auto item) {
		//rozsekat na auto a pobocku a nejdriv vlozit pobocku
		pobockaDao.insert(item.getPobocka());
				
		getDao().insert(item);
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
