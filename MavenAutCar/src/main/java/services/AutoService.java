package services;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import entities.Auto;

@Component
public class AutoService extends AbstractService<Auto> implements GenericService<Auto> {

	public void add(Auto item) {
		getDao().insert(item);
	}

	@Override
	public List<Auto> all() {
		return getDao().getAll();
	}

	@Override
	public Auto update(Integer id, Auto data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		getDao().delete(id);
	}
	/*
	@Override
	public Auto update(Integer id, Auto data) {
		Session s = getSf().openSession();
		Transaction t = s.beginTransaction();
		Auto temp = (Auto) s.get(Auto.class, id);
		temp.setKapacita(data.getKapacita());
		temp.setPobocka(data.getPobocka());
		temp.setVelikost(data.getVelikost());
		temp.setVybava(data.getVybava());
		temp.setVykonnost(data.getVykonnost());
		temp.setZnacka(data.getZnacka());
		t.commit();
		s.close();
		return temp;
	}*/

}
