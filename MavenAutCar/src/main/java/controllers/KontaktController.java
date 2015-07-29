package controllers;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	GenericDao<Kontakt> dao;
	
	public void setDao(GenericDao<Kontakt> dao) {
		this.dao = dao;
	}

	@Override
	public ModelAndView all() {
		ModelAndView mav = new ModelAndView("contacts/all");
		mav.addObject("contacts", dao.all());
		return mav;
	}

	@Override
	public Kontakt add(@RequestBody Kontakt item) {
		dao.add(item);
		return item;
	}

	@Override
	public Kontakt update(@RequestBody Kontakt item, @PathVariable Integer id) {
		dao.update(id, item);
		return item;
	}

	@Override
	public void delete(@PathVariable Integer id) {
		dao.delete(id);
	}
}
