package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entities.Pobocka;
import services.GenericService;
import services.PobockaService;

@RequestMapping(value = "/office")
@Controller
public class PobockaController extends AbstractController<Pobocka> implements GenericController<Pobocka> {

	private GenericService<Pobocka> service = new PobockaService();
	
	@Override
	public ModelAndView all() {
		ModelAndView mav = new ModelAndView("office/all");
		mav.addObject("offices", service.all());
		return mav;
	}

	@Override
	public Pobocka add(Pobocka item) {
		service.add(item);
		return item;
	}

	@Override
	public Pobocka update(Pobocka item, Integer id) {
		service.delete(id);
		return item;
	}

	@Override
	public void delete(Integer id) {
		service.delete(id);
	}

}
