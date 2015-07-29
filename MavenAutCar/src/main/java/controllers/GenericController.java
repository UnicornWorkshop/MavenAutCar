package controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

public interface GenericController<T> {
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public ModelAndView all();
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public @ResponseBody T add(@RequestBody T item);
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public @ResponseBody T update(@RequestBody T item, @PathVariable Integer id);
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public @ResponseBody void delete(@PathVariable Integer id);
}
