package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entities.Auto;
import services.AutoService;
import services.GenericService;

@RequestMapping(value = "/car")
@Controller
public class AutoController extends AbstractController<Auto>  implements GenericController<Auto> {

	private GenericService<Auto> service = new AutoService();
	
	@Override
	public ModelAndView all() {
		//GenericService<Auto> service = new AutoService();
		ModelAndView mav = new ModelAndView("car/all");
		mav.addObject("cars", service.all());
		return mav;
	}

	@Override
	public Auto add(@RequestBody Auto item) {
		service.add(item);
		return item;
	}

	@Override
	public Auto update(@RequestBody Auto item,@PathVariable Integer id) {
		service.update(id, item);
		return item;
	}

	@Override
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}

}
