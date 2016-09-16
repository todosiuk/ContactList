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
	public String getAdd(@RequestParam("id") Integer storeId, Model model) {
		Department department = new Department();
		department.setStore(storeService.getStoreFromId(storeId));
		model.addAttribute("departmentAttribute", department);
		return "adddeppage";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String postAdd(@RequestParam("id") Integer storeId,
			@ModelAttribute("departmentAttribute") Department department) {
		depService.create(storeId, department);
		return "addeddeppage";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("id") Integer depId) {
		depService.delete(depId);
		return "deleteddeppage";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String getUpdate(@RequestParam("sid") Integer storeId, @RequestParam("did") Integer depId, Model model) {
		Department existingDepartment = depService.getDepartmentFromId(depId);
		model.addAttribute("storeId", storeId);
		model.addAttribute("departmentAttribute", existingDepartment);
		return "editdeppage";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String saveUpdate(@RequestParam("id") Integer depId,
			@ModelAttribute("departmentAttribute") Department department) {
		department.setId(depId);
		depService.update(department);
		return "editeddeppage";
	}

}
