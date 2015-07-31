package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entities.Auto;
import facades.IAutoFacade;

@RequestMapping(value = "/car")
@Controller
public class AutoController extends AbstractController<Auto>  implements GenericController<Auto> {
	
	@Autowired
	private IAutoFacade autoFacade;
	
	@RequestMapping(value="/equipment/{id}", method=RequestMethod.GET)
	public ModelAndView allEquipment(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("car/equipment");
		mav.addObject("equipment", autoFacade.getEquipment(id));
		return mav;
	}
	
	@Override
	public ModelAndView all() {
		ModelAndView mav = new ModelAndView("car/all");
		mav.addObject("cars", getFacade().all());
		return mav;
	}

	@Override
	public Auto add(@RequestBody Auto item) {
		getFacade().add(item);
		return item;
	}

	@Override
	public Auto update(@RequestBody Auto item,@PathVariable Integer id) {
		getFacade().update(id, item);
		return item;
	}

	@Override
	public void delete(@PathVariable Integer id) {
		getFacade().delete(id);
	}

}
