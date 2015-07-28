package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entities.Kontakt;

@Controller
public class KontaktController {
	@RequestMapping(value="/kontakt", method=RequestMethod.GET)
	public ModelAndView kontakt() {
		return new ModelAndView("kontakt", "command", new Kontakt());
	}
	
	@RequestMapping(value="/addKontakt", method=RequestMethod.POST)
	public String addKontakt(@ModelAttribute("SpringWeb")Kontakt kontakt, ModelMap model) {
		return "add";
	}
	
	@RequestMapping(value="/deleteKontakt/{id}", method=RequestMethod.DELETE)
	public String deleteKontakt(@PathVariable("id")Integer id) { 
		return "delete";		
	}
	
	@RequestMapping(value="/updateKontakt/{id}", method=RequestMethod.PUT)
	public String updateKontakt(@PathVariable("id")Integer id) { 
		return "update";		
	}
}
