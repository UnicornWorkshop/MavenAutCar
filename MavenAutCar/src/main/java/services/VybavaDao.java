package services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import entities.Rezervace;
import entities.Vybava;

@Component
public class VybavaDao extends AbstractService implements GenericDao<Vybava> {

	@Override
	public void add(Vybava item) {
		Session s = getSf().openSession();
		Transaction t = s.beginTransaction();
		s.persist(item);
		t.commit();
		s.close();				
	}

	@Override
	public List<Vybava> all() {
		List<Vybava> vybava = new ArrayList<>();
		Session s = getSf().openSession();
		Transaction t = s.beginTransaction();

		Query q = s.createQuery("SELECT v FROM Vybava v");
		Iterator<Vybava> vysledek = q.iterate();
		while (vysledek.hasNext()) {
			vybava.add(vysledek.next());
		}

		t.commit();
		s.close();
		return vybava;
	}

	@Override
	public Vybava update(Integer id, Vybava data) {
		Session s = getSf().openSession();
		Transaction t = s.beginTransaction();
		Vybava temp = (Vybava) s.get(Vybava.class, id);
		temp.setNazev(data.getNazev());
		t.commit();
		s.close();
		return temp;
	}

	@Override
	public void delete(Integer id) {
		Session s = getSf().openSession();
		Transaction t = s.beginTransaction();
		Query q = s.createQuery("DELETE Vybava v WHERE v.id=:id")
				.setParameter("id", id);
		q.executeUpdate();
		t.commit();
		s.close();	
	}

}
