package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.GenericDao;
import entities.Rezervace;
import entities.Pobocka;
import entities.Klient;

@Component
public class RezervaceService extends AbstractService<Rezervace> implements GenericService<Rezervace> {
	
	@Autowired
	GenericDao<Klient> klientDao;
	@Autowired
	GenericDao<Pobocka> pobockaDao;
	
	@Override
	public void add(Rezervace item) {
		//vytahnout klienta a pobocky a ulozit to nejdriv
		klientDao.insert(item.getKlient());
		pobockaDao.insert(item.getPobocka_z());
		pobockaDao.insert(item.getPobocka_do());		
		
		getDao().insert(item);
	}

	@Override
	public List<Rezervace> all() {
		return getDao().getAll();
	}

	@Override
	public Rezervace update(Integer id, Rezervace item) {
		return getDao().update(id, item);
	}

	@Override
	public void delete(Integer id) {
		getDao().delete(id);
	}
}
