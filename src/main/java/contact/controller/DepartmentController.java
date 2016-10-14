package contact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import contact.entity.Department;
import contact.service.DepartmentServiceImpl;
import contact.service.StoreServiceImpl;

@Controller
@RequestMapping("/dep")
public class DepartmentController {

	@Autowired
	private StoreServiceImpl storeService;
	@Autowired
	private DepartmentServiceImpl depService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAdd(@RequestParam(value = "id", required = true) Integer storeId, Model model) {
		Department department = new Department();
		department.setStore(storeService.getStoreFromId(storeId));
		model.addAttribute("departmentAttribute", department);
		return "addDepartmentPage";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String postAdd(@RequestParam(value = "id", required = true) Integer storeId,
			@ModelAttribute("departmentAttribute") Department department) {
		depService.create(storeId, department);
		return "addedDepartmentPage";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam(value = "id", required = true) Integer depId) {
		depService.delete(depId);
		return "deletedDepartmentPage";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String getUpdate(@RequestParam(value = "storeId", required = true) Integer storeId,
			@RequestParam("depId") Integer depId, Model model) {
		Department department = new Department();
		department.setStore(storeService.getStoreFromId(storeId));
		model.addAttribute("storeId", storeId);
		model.addAttribute("departmentAttribute", depService.getDepartmentFromId(depId));
		return "editDepartmentPage";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String postUpdate(@RequestParam(value = "depId", required = true) Integer depId,
			@RequestParam(value = "storeId", required = true) Integer storeId,
			@ModelAttribute("departmentAttribute") Department department) {
		department.setId(depId);
		depService.update(department);
		return "editedDepPage";
	}

}
