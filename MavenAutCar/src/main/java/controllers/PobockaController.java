package controllers;

import org.springframework.web.servlet.ModelAndView;

import dao.GenericDao;
import dao.PobockaDao;
import entities.Pobocka;

public class PobockaController implements GenericController<Pobocka> {

	@Override
	public ModelAndView all() {
		GenericDao<Pobocka> dao = new PobockaDao();
		ModelAndView mav = new ModelAndView("office/all");
		mav.addObject("offices", dao.all());
		return mav;
	}

	@Override
	public Pobocka add(Pobocka item) {
		GenericDao<Pobocka> dao = new PobockaDao();
		dao.add(item);
		return item;
	}

	@Override
	public Pobocka update(Pobocka item, Integer id) {
		GenericDao<Pobocka> dao = new PobockaDao();
		dao.delete(id);
		return item;
	}

	@Override
	public void delete(Integer id) {
		GenericDao<Pobocka> dao = new PobockaDao();
		dao.delete(id);
	}
		
}
