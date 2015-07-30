package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entities.Rezervace;
import services.GenericService;
import services.RezervaceService;

@RequestMapping(value = "/reservation")
@Controller
public class RezervaceController extends AbstractController<Rezervace> implements GenericController<Rezervace> {

	private GenericService<Rezervace> service = new RezervaceService();
	
	@Override
	public ModelAndView all() {
		ModelAndView mav = new ModelAndView("reservation/all");
		mav.addObject("reservations", service.all());
		return mav;
	}

	@Override
	public Rezervace add(@RequestBody Rezervace item) {
		service.add(item);
		return item;
	}

	@Override
	public Rezervace update(@RequestBody Rezervace item,
			@PathVariable Integer id) {
		service.update(id, item);
		return item;
	}

	@Override
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}

}
