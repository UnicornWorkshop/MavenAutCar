package dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import entities.Auto;

@Component
public class AutoDao extends AbstractDao implements GenericDao<Auto> {

	@Override
	public Auto get(Integer id) {
		return (Auto) getSession().get(Auto.class, id);
	}

	@Override
	public void insert(Auto item) {
		getSession().persist(item);		
	}

	@Override
	public List<Auto> getAll() {
		List<Auto> cars = new ArrayList<Auto>();
		createSession();
		
		
		
		/*
		List<Auto> cars = new ArrayList<Auto>();
createSession();
		Session s = getSf().openSession();
		Transaction t = s.beginTransaction();

		Query q = s.createQuery("SELECT a FROM Auto a");
		Iterator<Auto> result = q.iterate();
		while (result.hasNext()) {
			cars.add(result.next());
		}

		t.commit();
		s.close();
		return cars;*/
		
		return null;
		
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
}
/*
@Override
	public void add(Auto item) {
		Session s = getSf().openSession();
		Transaction t = s.beginTransaction();
		s.persist(item);
		t.commit();
		s.close();
	}

	@Override
	public List<Auto> all() {
		List<Auto> cars = new ArrayList<Auto>();

		Session s = getSf().openSession();
		Transaction t = s.beginTransaction();

		Query q = s.createQuery("SELECT a FROM Auto a");
		Iterator<Auto> result = q.iterate();
		while (result.hasNext()) {
			cars.add(result.next());
		}

		t.commit();
		s.close();
		return cars;
	}

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
	}

	@Override
	public void delete(Integer id) {
		Session s = getSf().openSession();
		Transaction t = s.beginTransaction();
		Query q = s.createQuery("DELETE Auto a WHERE a.id=:id").setParameter(
				"id", id);
		q.executeUpdate();
		t.commit();
		s.close();
	}
*/