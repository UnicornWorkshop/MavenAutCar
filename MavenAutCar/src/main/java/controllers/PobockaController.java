package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dao.GenericDao;
import dao.PobockaDao;
import entities.Pobocka;

@Controller
@RequestMapping("/pobocka")
public class PobockaController {
		
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public ModelAndView clients() {
		
		GenericDao<Pobocka> dao = new PobockaDao();
		
		ModelAndView mav = new ModelAndView("pobocka/pobocky");
		mav.addObject("pobocky", dao.showAll());

		return mav;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public @ResponseBody Pobocka addPobocka(@RequestBody final Pobocka pobocka) {
		
		Pobocka p = new Pobocka(pobocka.getMesto());
		GenericDao<Pobocka> dao = new PobockaDao();
		dao.add(p);
		return p;
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
	public @ResponseBody Pobocka updatePobocka(@RequestBody final Pobocka zmeny) {
		/*System.out.println("id: " + klient.getId());
		System.out.println("jmeno: " + klient.getJmeno());
		klient.setJmeno("bc. " + klient.getJmeno());
		
		Klient k = new Klient(klient.getJmeno());
		GenericDao<Klient> dao = new KlientDao();
		dao.add(k);
		
		return klient;*/
		return new Pobocka(); //pak smazat
	}
}
