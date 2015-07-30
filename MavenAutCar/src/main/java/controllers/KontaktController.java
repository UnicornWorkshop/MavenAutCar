package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entities.Kontakt;

@RequestMapping(value = "/contact")
@Controller
public class KontaktController extends AbstractController<Kontakt> implements GenericController<Kontakt> {
	
	@Override
	public ModelAndView all() {
		ModelAndView mav = new ModelAndView("contacts/all");
		mav.addObject("contacts", getService().all());
		return mav;
	}

	@Override
	public Kontakt add(@RequestBody Kontakt item) {
		getService().add(item);
		return item;
	}

	@Override
	public Kontakt update(@RequestBody Kontakt item, @PathVariable Integer id) {
		getService().update(id, item);
		return item;
	}

	@Override
	public void delete(@PathVariable Integer id) {
		getService().delete(id);
	}
}
