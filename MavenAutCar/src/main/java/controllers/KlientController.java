package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import entities.Klient;
import entities.Kontakt;
import dao.KlientDao;

@Controller
public class KlientController {
	@RequestMapping(value="/klient", method=RequestMethod.GET)
	public ModelAndView klient() {
		return new ModelAndView("kontakt", "command", new Klient());
	}
	
	@RequestMapping(value="/addKlient", method=RequestMethod.POST)
	public @ResponseBody Klient addKlient(@RequestBody final Klient klient) {
		System.out.println("id: " + klient.getId());
		System.out.println("jmeno: " + klient.getJmeno());
		klient.setJmeno("bc. " + klient.getJmeno());
		
		Klient k = new Klient(klient.getJmeno());
		KlientDao dao = new KlientDao();
		dao.addKlient(k);
		
		return klient;
	}
}
