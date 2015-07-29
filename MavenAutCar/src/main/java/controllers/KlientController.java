package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entities.Klient;

@RequestMapping(value = "/client")
@Controller
public class KlientController extends AbstractController<Klient> implements GenericController<Klient> {

	@Override
	public ModelAndView all() {
		ModelAndView mav = new ModelAndView("client/all");
		mav.addObject("clients", getDao().all());
		return mav;
	}

	public Klient add(@RequestBody final Klient item) {
		getDao().add(item);
		return item;
	}

	@Override
	public Klient update(@RequestBody Klient item,@PathVariable Integer id) {
		getDao().update(id, item);
		return item;
	}

	@Override
	public void delete(@PathVariable Integer id) {
		getDao().delete(id);
	}
	
}
