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
	public Rezervace update(Integer id, Rezervace data) {
		Rezervace item = new Rezervace();
		item = (Rezervace) getDao().get(id);
		item.setKlient(data.getKlient());
		item.setAuto(data.getAuto());
		item.setDatum_do(data.getDatum_do());
		item.setDatum_od(data.getDatum_od());
		item.setPobocka_do(data.getPobocka_do());
		item.setPobocka_z(data.getPobocka_z());
		return item;
	}

	@Override
	public void delete(Integer id) {
		getDao().delete(id);
	}
}
