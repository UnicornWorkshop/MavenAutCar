package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entities.Pobocka;

@RequestMapping(value = "/office")
@Controller
public class PobockaController extends AbstractController<Pobocka> implements GenericController<Pobocka> {
	
	@Override
	public ModelAndView all() {
		ModelAndView mav = new ModelAndView("office/all");
		mav.addObject("offices", getService().all());
		return mav;
	}

	@Override
	public Pobocka add(@RequestBody Pobocka item) {
		getService().add(item);
		return item;
	}

	@Override
	public Pobocka update(@RequestBody Pobocka item, @PathVariable Integer id) {
		return getService().update(id, item);
	}

	@Override
	public void delete(@PathVariable Integer id) {
		getService().delete(id);
	}

}
