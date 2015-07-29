package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.GenericDao;
import dao.KlientDao;
import dao.RezervaceDao;
import entities.Klient;
import entities.Rezervace;

@RequestMapping(value = "/reservation")
@Controller
public class RezervaceController implements GenericController<Rezervace> {

	@Autowired
	GenericDao<Rezervace> dao;
	
	public void setDao(GenericDao<Rezervace> dao) {
		this.dao = dao;
	}

	@Override
	public ModelAndView all() {
		ModelAndView mav = new ModelAndView("reservation/all");
		mav.addObject("reservations", dao.all());
		return mav;
	}

	@Override
	public Rezervace add(@RequestBody Rezervace item) {
		dao.add(item);
		return item;
	}

	@Override
	public Rezervace update(@RequestBody Rezervace item,
			@PathVariable Integer id) {
		dao.update(id, item);
		return item;
	}

	@Override
	public void delete(@PathVariable Integer id) {
		dao.delete(id);
	}

}
