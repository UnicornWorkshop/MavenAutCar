package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entities.Auto;

@RequestMapping(value = "/car")
@Controller
public class AutoController extends AbstractController<Auto>  implements GenericController<Auto> {

	@Override
	public ModelAndView all() {
		ModelAndView mav = new ModelAndView("car/all");
		mav.addObject("cars", getDao().all());
		return mav;
	}

	@Override
	public Auto add(@RequestBody Auto item) {
		getDao().add(item);
		return item;
	}

	@Override
	public Auto update(@RequestBody Auto item,@PathVariable Integer id) {
		getDao().update(id, item);
		return item;
	}

	@Override
	public void delete(@PathVariable Integer id) {
		getDao().delete(id);
	}

}
