package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entities.Pobocka;

@RequestMapping(value = "/office")
@Controller
public class PobockaController extends AbstractController<Pobocka> implements GenericController<Pobocka> {

	@Override
	public ModelAndView all() {
		ModelAndView mav = new ModelAndView("office/all");
		mav.addObject("offices", getDao().all());
		return mav;
	}

	@Override
	public Pobocka add(Pobocka item) {
		getDao().add(item);
		return item;
	}

	@Override
	public Pobocka update(Pobocka item, Integer id) {
		getDao().delete(id);
		return item;
	}

	@Override
	public void delete(Integer id) {
		getDao().delete(id);
	}

}
