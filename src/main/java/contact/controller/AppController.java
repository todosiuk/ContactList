package contact.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import contact.entity.Department;
import contact.entity.Store;
import contact.service.DepartmentService;
import contact.service.ServiceInt;
import contact.service.StoreService;

@Controller
public class AppController {

	@Autowired
	private StoreService storeService;

	@Autowired
	private DepartmentService departmentService;

	@RequestMapping("/storeform")
	public ModelAndView showform() {
		return new ModelAndView("storeform", "command", new Store());
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView create(@ModelAttribute("store") Store store) {
		storeService.create(store);
		return new ModelAndView("redirect:/viewstore");
	}

	@RequestMapping("/viewstore")
	public ModelAndView viewstore() {
		List<Store> list = storeService.read();
		return new ModelAndView("viewstore", "list", list);
	}

	@RequestMapping(value = "/editstore/{id}")
	public ModelAndView edit(@PathVariable int id) {
		Store store = storeService.getStoreFromId(id);
		return new ModelAndView("storeeditform", "command", store);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("store") Store store) {
		storeService.update(store);
		return new ModelAndView("redirect:/viewstore");
	}

	@RequestMapping(value = "/deletestore/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		storeService.delete(id);
		return new ModelAndView("redirect:/viewstore");
	}

	@RequestMapping("/departmentform")
	public ModelAndView showdepform() {
		return new ModelAndView("departmentform", "command", new Department());
	}

	public ModelAndView createdep(@ModelAttribute("department") Department department) {
		departmentService.create(department);
		return new ModelAndView("redirect:/viewdep");
	}
}