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
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView showForm() {
		return new ModelAndView("storeform", "command", new Store());
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createStore(@ModelAttribute("store") Store store) {
		storeService.create(store, null);
		return new ModelAndView("redirect:/viewstore");
	}

	@RequestMapping("/viewstore")
	public ModelAndView viewStore() {
		List<Store> list = storeService.read();
		return new ModelAndView("viewstore", "list", list);
	}

	@RequestMapping("/editstore/{id}")
	public ModelAndView editStore(@PathVariable int id) {
		Store store = storeService.getStoreFromId(id);
		return new ModelAndView("storeeditform", "command", store);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateStore(@ModelAttribute("store") Store store) {
		storeService.update(store);
		return new ModelAndView("redirect:/viewstore");
	}

	@RequestMapping(value = "/deletestore/{id}", method = RequestMethod.GET)
	public ModelAndView deleteStore(@PathVariable int id) {
		storeService.delete(id);
		return new ModelAndView("redirect:/viewstore");
	}

	@RequestMapping("/departmentform")
	public ModelAndView showDepForm() {
		return new ModelAndView("departmentform", "command", new Department());
	}

	@RequestMapping(value = "/createdepartment", method = RequestMethod.POST)
	public ModelAndView createDep(@RequestParam("id") Integer id, @ModelAttribute("department") Department department) {
		departmentService.create(department, id);
		return new ModelAndView("redirect:/viewdep");
	}

	@RequestMapping("/viewdep")
	public ModelAndView viewDep() {
		List<Department> depList = departmentService.read();
		return new ModelAndView("viewdep", "depList", depList);
	}

	@RequestMapping("/editdep/{id}")
	public ModelAndView editDep(@PathVariable int id) {
		Department department = departmentService.getDepartmentFromId(id);
		return new ModelAndView("departmenteditform", "command", department);
	}

	@RequestMapping(value = "/updatedep", method = RequestMethod.POST)
	public ModelAndView updateDep(@ModelAttribute("department") Department department) {
		departmentService.update(department);
		return new ModelAndView("redirect:/viewdep");
	}

	@RequestMapping(value = "/deletedep/{id}", method = RequestMethod.GET)
	public ModelAndView deleteDep(@PathVariable int id) {
		departmentService.delete(id);
		return new ModelAndView("redirect:/viewdep");
	}
	
	public ModelAndView getDepForStore(@PathVariable int id){
		storeService.getDepartmentsForStore(id)
	}

}