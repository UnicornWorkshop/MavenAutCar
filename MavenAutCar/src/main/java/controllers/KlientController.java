package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entities.Klient;
import dao.GenericDao;
import dao.KlientDao;

@RequestMapping(value = "/klient")
@Controller
public class KlientController implements GenericController<Klient> {

	@Override
	public ModelAndView all() {
		GenericDao<Klient> dao = new KlientDao();
		ModelAndView mav = new ModelAndView("klient/all");
		mav.addObject("clients", dao.all());
		return mav;
	}

	@Override
	public Klient add(@RequestBody final Klient item) {
		GenericDao<Klient> dao = new KlientDao();
		dao.add(item);
		return item;
	}

	@Override
	public Klient update(@RequestBody Klient item,@PathVariable Integer id) {
		GenericDao<Klient> dao = new KlientDao();
		dao.update(id, item);
		return item;
	}

	@Override
	public void delete(@PathVariable Integer id) {
		GenericDao<Klient> dao = new KlientDao();
		dao.delete(id);
	}

}
