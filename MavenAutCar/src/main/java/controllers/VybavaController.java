package controllers;

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

	@Override
	public ModelAndView all() {
		GenericDao<Vybava> dao = new VybavaDao();
		ModelAndView mav = new ModelAndView("equipment/all");
		mav.addObject("equipments", dao.all());
		return mav;
	}

	@Override
	public Vybava add(@RequestBody Vybava item) {
		GenericDao<Vybava> dao = new VybavaDao();
		dao.add(item);
		return item;
	}

	@Override
	public Vybava update(@RequestBody Vybava item, @PathVariable Integer id) {
		GenericDao<Vybava> dao = new VybavaDao();
		dao.delete(id);
		return item;
	}

	@Override
	public void delete(@PathVariable Integer id) {
		GenericDao<Vybava> dao = new VybavaDao();
		dao.delete(id);
	}

}
