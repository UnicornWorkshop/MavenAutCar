package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import entities.Klient;

@RequestMapping(value = "/client")
@Controller
public class KlientController extends AbstractController<Klient> implements GenericController<Klient> {
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody ModelAndView newKlient() {
		ModelAndView mav = new ModelAndView("client/new");
		mav.addObject("clients", getFacade().all());
		return mav;
	}

	@Override
	public ModelAndView all() {
		ModelAndView mav = new ModelAndView("client/all");
		mav.addObject("clients", getFacade().all());
		return mav;
	}

	public Klient add(@RequestBody final Klient item) {
		getFacade().add(item);
		return item;
	}

	@Override
	public Klient update(@RequestBody Klient item,@PathVariable Integer id) {
		return getFacade().update(id, item);
	}

	@Override
	public void delete(@PathVariable Integer id) {
		getFacade().delete(id);
	}
	
}
