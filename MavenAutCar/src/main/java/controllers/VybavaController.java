package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.GenericDao;
import dao.VybavaDao;
import entities.Rezervace;
import entities.Vybava;

@RequestMapping(value = "/equipment")
@Controller
public class VybavaController implements GenericController<Vybava> {

	@Autowired
	GenericDao<Vybava> dao;
	
	public void setDao(GenericDao<Vybava> dao) {
		this.dao = dao;
	}

	@Override
	public ModelAndView all() {
		ModelAndView mav = new ModelAndView("equipment/all");
		mav.addObject("equipments", dao.all());
		return mav;
	}

	@Override
	public Vybava add(@RequestBody Vybava item) {
		dao.add(item);
		return item;
	}

	@Override
	public Vybava update(@RequestBody Vybava item, @PathVariable Integer id) {
		dao.delete(id);
		return item;
	}

	@Override
	public void delete(@PathVariable Integer id) {
		dao.delete(id);
	}

}
