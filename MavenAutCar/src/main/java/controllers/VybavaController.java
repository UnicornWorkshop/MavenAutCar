package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entities.Vybava;

@RequestMapping(value = "/equipment")
@Controller
public class VybavaController extends AbstractController<Vybava> implements GenericController<Vybava> {

	@Override
	public ModelAndView all() {
		ModelAndView mav = new ModelAndView("equipment/all");
		mav.addObject("equipments", getService().all());
		return mav;
	}

	@Override
	public Vybava add(@RequestBody Vybava item) {
		getService().add(item);
		return item;
	}

	@Override
	public Vybava update(@RequestBody Vybava item, @PathVariable Integer id) {
		getService().delete(id);
		return item;
	}

	@Override
	public void delete(@PathVariable Integer id) {
		getService().delete(id);
	}

}
