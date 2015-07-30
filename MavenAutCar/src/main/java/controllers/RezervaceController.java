package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entities.Rezervace;

@RequestMapping(value = "/reservation")
@Controller
public class RezervaceController extends AbstractController<Rezervace> implements GenericController<Rezervace> {
	
	@Override
	public ModelAndView all() {
		ModelAndView mav = new ModelAndView("reservation/all");
		mav.addObject("reservations", getService().all());
		return mav;
	}

	@Override
	public Rezervace add(@RequestBody Rezervace item) {
		getService().add(item);
		return item;
	}

	@Override
	public Rezervace update(@RequestBody Rezervace item,@PathVariable Integer id) {
		return getService().update(id, item);
	}

	@Override
	public void delete(@PathVariable Integer id) {
		getService().delete(id);
	}

}
