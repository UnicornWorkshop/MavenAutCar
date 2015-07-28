package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import entities.Klient;
import entities.Kontakt;

@Controller
public class KlientController {
	@RequestMapping(value="/klient", method=RequestMethod.GET)
	public ModelAndView klient() {
		return new ModelAndView("kontakt", "command", new Kontakt());
	}
	
	@RequestMapping(value="/addKontakt", method=RequestMethod.POST)
	public @ResponseBody Klient addKlient(@RequestBody final Klient klient) {
		System.out.println("id: " + klient.getId());
		System.out.println("jmeno: " + klient.getJmeno());
		return klient;
	}
}
