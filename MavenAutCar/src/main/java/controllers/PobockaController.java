package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.GenericDao;
import dao.KlientDao;
import dao.PobockaDao;
import entities.Klient;
import entities.Pobocka;

@Controller
@RequestMapping("/pobocka")
public class PobockaController {
		
	@RequestMapping(value="/pobocky", method=RequestMethod.GET)
	public ModelAndView clients() {
		
		GenericDao<Pobocka> dao = new PobockaDao();
		
		ModelAndView mav = new ModelAndView("pobocka/pobocky");
		mav.addObject("pobocky", dao.showAll());

		return mav;
	}
	
}
