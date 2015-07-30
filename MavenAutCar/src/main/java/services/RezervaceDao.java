package services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import entities.Pobocka;
import entities.Rezervace;

@Component
public class RezervaceDao extends AbstractService implements GenericDao<Rezervace> {

	@Override
	public void add(Rezervace item) {
		Session s = getSf().openSession();
		Transaction t = s.beginTransaction();
		s.persist(item);
		t.commit();
		s.close();		
	}
	//

	@Override
	public List<Rezervace> all() {
		List<Rezervace> rezervace = new ArrayList<>();
		Session s = getSf().openSession();
		Transaction t = s.beginTransaction();

		Query q = s.createQuery("SELECT r FROM Rezervace r");
		Iterator<Rezervace> vysledek = q.iterate();
		while (vysledek.hasNext()) {
			rezervace.add(vysledek.next());
		}

		t.commit();
		s.close();
		return rezervace;
	}

	@Override
	public Rezervace update(Integer id, Rezervace data) {
		Session s = getSf().openSession();
		Transaction t = s.beginTransaction();
		Rezervace temp = (Rezervace) s.get(Rezervace.class, id);
		temp.setAuto(data.getAuto());
		temp.setDatum_do(data.getDatum_do());
		temp.setDatum_od(data.getDatum_od());
		temp.setKlient(data.getKlient());
		temp.setPobocka_do(data.getPobocka_do());
		temp.setPobocka_z(data.getPobocka_z());
		t.commit();
		s.close();
		return temp;
	}

	@Override
	public void delete(Integer id) {
		Session s = getSf().openSession();
		Transaction t = s.beginTransaction();
		Query q = s.createQuery("DELETE Rezervace r WHERE r.id=:id")
				.setParameter("id", id);
		q.executeUpdate();
		t.commit();
		s.close();
		
	}

}
