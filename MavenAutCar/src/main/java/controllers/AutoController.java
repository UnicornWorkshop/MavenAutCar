package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.AutoDao;
import dao.GenericDao;
import entities.Auto;

@RequestMapping(value = "/car")
@Controller
public class AutoController implements GenericController<Auto> {

	@Autowired
	GenericDao<Auto> dao;
	
	public void setDao(GenericDao<Auto> dao) {
		this.dao = dao;
	}

	@Override
	public ModelAndView all() {
		GenericDao<Auto> dao = new AutoDao();
		ModelAndView mav = new ModelAndView("auto/all");
		mav.addObject("cars", dao.all());
		return mav;
	}

	@Override
	public Auto add(@RequestBody Auto item) {
		dao.add(item);
		return item;
	}

	@Override
	public Auto update(@RequestBody Auto item,@PathVariable Integer id) {
		dao.update(id, item);
		return item;
	}

	@Override
	public void delete(@PathVariable Integer id) {
		dao.delete(id);
	}

}
