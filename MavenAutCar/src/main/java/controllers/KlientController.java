package controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import entities.Klient;
import dao.GenericDao;
import dao.KlientDao;

@RequestMapping(value="/klient")
@Controller
public class KlientController implements GenericController<Klient> {
	

	public ModelAndView all() {
		GenericDao<Klient> dao = new KlientDao();
		ModelAndView mav = new ModelAndView("klient/all");
		mav.addObject("clients", dao.showAll());
		return mav;
	}
	

	public  Klient add( final Klient klient) {
		System.out.println("id: " + klient.getId());
		System.out.println("jmeno: " + klient.getJmeno());
		klient.setJmeno("bc. " + klient.getJmeno());
		Klient k = new Klient(klient.getJmeno());
		GenericDao<Klient> dao = new KlientDao();
		dao.add(k);
		return klient;
	}

	public Klient update( Klient klient, Integer id) {
		KlientDao dao = new KlientDao();
		dao.update(id, klient);
		return klient;
	}
	

	public void delete( Integer id) {
		System.out.println(id);
		GenericDao<Klient> dao = new KlientDao();
		dao.delete(id);		
	}
	
	
}
