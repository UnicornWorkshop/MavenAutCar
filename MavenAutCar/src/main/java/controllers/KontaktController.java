package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.GenericDao;
import dao.KontaktDao;
import entities.Kontakt;

@RequestMapping(value = "/contact")
@Controller
public class KontaktController implements GenericController<Kontakt> {

	@Override
	public ModelAndView all() {
		GenericDao<Kontakt> dao = new KontaktDao();
		ModelAndView mav = new ModelAndView("contacts/all");
		mav.addObject("contacts", dao.all());
		return mav;
	}

	@Override
	public Kontakt add(@RequestBody Kontakt item) {
		GenericDao<Kontakt> dao = new KontaktDao();
		dao.add(item);
		return item;
	}

	@Override
	public Kontakt update(@RequestBody Kontakt item, @PathVariable Integer id) {
		GenericDao<Kontakt> dao = new KontaktDao();
		dao.update(id, item);
		return item;
	}

	@Override
	public void delete(@PathVariable Integer id) {
		GenericDao<Kontakt> dao = new KontaktDao();
		dao.delete(id);
	}


}
