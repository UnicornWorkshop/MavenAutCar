package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entities.Kontakt;
import services.GenericService;
import services.KontaktService;

@RequestMapping(value = "/contact")
@Controller
public class KontaktController extends AbstractController<Kontakt> implements GenericController<Kontakt> {

	private GenericService<Kontakt> service = new KontaktService();
	
	@Override
	public ModelAndView all() {
		ModelAndView mav = new ModelAndView("contacts/all");
		mav.addObject("contacts", service.all());
		return mav;
	}

	@Override
	public Kontakt add(@RequestBody Kontakt item) {
		service.add(item);
		return item;
	}

	@Override
	public Kontakt update(@RequestBody Kontakt item, @PathVariable Integer id) {
		service.update(id, item);
		return item;
	}

	@Override
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
