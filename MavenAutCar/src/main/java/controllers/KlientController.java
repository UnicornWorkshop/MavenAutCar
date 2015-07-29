package controllers;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entities.Klient;
import dao.GenericDao;
import dao.KlientDao;

@RequestMapping(value = "/client")
@Controller
public class KlientController implements GenericController<Klient> {

	@Autowired
	GenericDao<Klient> dao;
		
	public void setDao(GenericDao<Klient> dao) {
		this.dao = dao;
	}

	@Override
	public ModelAndView all() {
		ModelAndView mav = new ModelAndView("client/all");
		mav.addObject("clients", dao.all());
		ModelMap mm = new ModelMap();
		mm.addAttribute("clients", dao.all());
		return mav;
	}

	public Klient add(@RequestBody final Klient item) {
		dao.add(item);
		return item;
	}

	@Override
	public Klient update(@RequestBody Klient item,@PathVariable Integer id) {
		dao.update(id, item);
		return item;
	}

	@Override
	public void delete(@PathVariable Integer id) {
		dao.delete(id);
	}

}
