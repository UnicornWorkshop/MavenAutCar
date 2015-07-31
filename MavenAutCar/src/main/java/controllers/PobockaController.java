package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.GenericDao;
import dao.PobockaDao;
import entities.Pobocka;
import services.IPobockaService;

@RequestMapping(value = "/office")
@Controller
public class PobockaController extends AbstractController<Pobocka> implements GenericController<Pobocka> {
	
	@Autowired
	private IPobockaService pobockaDao;
	
	@RequestMapping(value="/cars/{id}", method=RequestMethod.GET)
	public ModelAndView allCars(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("office/cars");
		mav.addObject("cars", pobockaDao.getCars(id));
		return mav;
	}
	
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
