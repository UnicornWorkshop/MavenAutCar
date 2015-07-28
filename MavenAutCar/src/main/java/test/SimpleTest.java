package test;

import entities.*;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;

public class SimpleTest {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		Pobocka p = new Pobocka("Brno");
		s.persist(p);
		
		Auto a = new Auto("Skoda", 200, 10000, 4);
		s.persist(a);
		Auto a2 = new Auto("Peugeot", 200, 10000, 4);
		s.persist(a2);
		Auto a3 = new Auto("Porsche", 500, 8000, 2);
		s.persist(a3);
		
		Vybava v = new Vybava("navigace");
		s.persist(v);
		Vybava v2 = new Vybava("klimatizace");
		s.persist(v2);
		
		a.setPobocka(p);
		Set<Vybava> vybava = new HashSet<Vybava>();
		vybava.add(v);
		vybava.add(v2);
		a.setVybava(vybava);
		
		//a.setKapacita(1);
		Query q = s.createQuery("SELECT a FROM Auto a WHERE a.kapacita > :lidi");
		q.setParameter("lidi", Integer.valueOf(2));
		Iterator<Auto> vysledek = q.iterate();
		while(vysledek.hasNext()) {
			System.out.println(vysledek.next().getZnacka());
		}		
		
		t.commit();
		s.close();
	}
}