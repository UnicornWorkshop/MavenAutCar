package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.GenericDao;
import entities.Kontakt;
import entities.Klient;

@Component
public class KontaktService extends AbstractService<Kontakt> implements GenericService<Kontakt> {

	@Autowired
	private GenericDao<Klient> klientDao;
	
	@Override
	public void add(Kontakt item) {
		//rozbit na klienta a kontakt a vlozit nejdriv kontakt
		klientDao.insert(item.getKlient());
		
		getDao().insert(item);
	}

	@Override
	public List<Kontakt> all() {
		return getDao().getAll();
	}

	@Override
	public Kontakt update(Integer id, Kontakt item) {
		/*Kontakt item = new Kontakt();
		item = (Kontakt) getDao().get(id);
		item.setKlient(data.getKlient());
		item.setTyp(data.getTypEnum());
		item.setData(data.getData());*/
		return getDao().update(id, item);	
	}

	@Override
	public void delete(Integer id) {
		getDao().delete(id);
	}
}
