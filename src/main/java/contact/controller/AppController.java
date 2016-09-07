package contact.controller;

import java.io.IOException;
import java.util.Collection;
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
import contact.service.DepartmentServiceImpl;
import contact.service.StoreService;
import contact.service.StoreServiceImpl;

@Controller
public class AppController {

	@Autowired
	private DepartmentServiceImpl departmentService;

	@RequestMapping("/storeform")
	public ModelAndView showForm() {
		return new ModelAndView("storeform", "command", new Store());
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createStore(@ModelAttribute("store") Store store) {
		storeService.create(store);
		return new ModelAndView("redirect:/viewstore");
	}

	@RequestMapping("/viewstore")
	public ModelAndView viewStore() {
		List<Store> list = storeService.read();
		return new ModelAndView("viewstore", "list", list);
	}

	@RequestMapping("/editstore/{id}")
	public ModelAndView editStore(@PathVariable int id) {
		Store store = (Store) storeService.getStoreFromId(id);
		return new ModelAndView("storeeditform", "command", new Store());
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

	@RequestMapping(value = "/departmentform", method = RequestMethod.GET)
	public String showDepForm(@RequestParam("id") Integer storeId, Model model) {
		Department department = new Department();
		department.setStore(storeService.getStoreFromId(storeId));
		model.addAttribute("departmentAttribute", department);
		return "departmentform";

	}

	@RequestMapping(value = "/createdepartment", method = RequestMethod.POST)
	public String createDep(@RequestParam("id") Integer storeId,
			@ModelAttribute("departmentAttribute") Department department) {
		departmentService.create(storeId, department);
		return "viewdep";

	}

	@RequestMapping("/viewdep")
	public ModelAndView viewDep() {
		List<Department> depList = departmentService.read();
		return new ModelAndView("viewdep", "depList", depList);
	}

	@RequestMapping("/editdep/{id}")
	public ModelAndView editDep(@PathVariable Integer id) {
		Department department = departmentService.getDepartmentFromId(id);
		return new ModelAndView("departmenteditform", "department", department);
	}

	@RequestMapping(value = "/updatedep", method = RequestMethod.POST)
	public ModelAndView updateDep(@ModelAttribute("department") Department department) {
		departmentService.update(department);
		return new ModelAndView("redirect:/viewdep");
	}

	@RequestMapping(value = "/deletedep/{id}", method = RequestMethod.GET)
	public ModelAndView deleteDep(@PathVariable Integer id) {
		departmentService.delete(id);
		return new ModelAndView("redirect:/viewdep");
	}

	@RequestMapping("/viewdepforstore")
	public ModelAndView viewDepForStore() {
		List<Department> departList = departmentService.read();
		return new ModelAndView("viewdepforstore", "departList", departList);
	}

	@RequestMapping(value = "/depforstore/{id}")
	public ModelAndView getDepForStore(@PathVariable Integer id) {
		Collection<Department> depList = storeService.getDepartmentsForStore(id);
		return new ModelAndView("redirect:/viewdepforstore");

	}

}