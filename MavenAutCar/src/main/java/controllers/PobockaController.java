package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.GenericDao;
import dao.PobockaDao;
import entities.Pobocka;

@RequestMapping(value = "/office")
@Controller
public class PobockaController implements GenericController<Pobocka> {

	@Autowired
	GenericDao<Pobocka> dao;
	
	public void setDao(GenericDao<Pobocka> dao) {
		this.dao = dao;
	}

	@Override
	public ModelAndView all() {
		ModelAndView mav = new ModelAndView("office/all");
		mav.addObject("offices", dao.all());
		return mav;
	}

	@Override
	public Pobocka add(Pobocka item) {
		dao.add(item);
		return item;
	}

	@Override
	public Pobocka update(Pobocka item, Integer id) {
		dao.delete(id);
		return item;
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

}
