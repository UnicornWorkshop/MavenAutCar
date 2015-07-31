package services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.IPobockaDao;
import entities.Auto;
import entities.Pobocka;

@Component
public class PobockaService extends AbstractService<Pobocka> implements IPobockaService {

	@Autowired
	IPobockaDao pobockaDao;
	
	@Override
	public Set<Auto> getCars(Integer id) {
		return pobockaDao.getCars(id);
	}
	
	@Override
	public void add(Pobocka item) {
		getDao().insert(item);
	}

	@Override
	public List<Pobocka> all() {
		return getDao().getAll();
	}

	@Override
	public Pobocka update(Integer id, Pobocka item) {
		return getDao().update(id, item);
	}

	@Override
	public void delete(Integer id) {
		getDao().delete(id);
	}
}
