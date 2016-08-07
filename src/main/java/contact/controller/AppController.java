package contact.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import contact.entity.Department;
import contact.entity.Store;
import contact.service.DepartmentService;
import contact.service.ServiceInt;
import contact.service.StoreService;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	private ServiceInt<Department, ?> departmentService;
	@Autowired
	private ServiceInt<Store, ?> storeService;

	@RequestMapping("/listdepartments")
	public String listDepartments(Map<String, Object> map) {
		map.put("department", new Department());
		map.put("departmentList", departmentService.read());
		return "departmentlist";
	}

	@RequestMapping("/liststore")
	public String listStore(Map<String, Object> map) {
		map.put("store", new Store());
		map.put("storeList", storeService.read());
		return "storelist";
	}

	@RequestMapping("/adddepartment")
	public String addDepartment(@ModelAttribute("department") Department department, BindingResult result) {
		departmentService.create(department);
		return "adddepartment";
	}

	@RequestMapping("/addstore")
	public String addStore(@ModelAttribute("store") Store store, BindingResult result) {
		storeService.create(store);
		return ("addstore");

	}

	@RequestMapping("/deletedepartment/{departmentId}")
	public String deleteDepartment(@PathVariable("departmentId") Integer departmentId) {
		departmentService.delete(departmentId);
		return "deletedepartment";
	}

	@RequestMapping("/deletestore/{storeId}")
	public String deleteStore(@PathVariable("StoreId") Integer storeId) {
		storeService.delete(storeId);
		return "deletestore";
	}

	@RequestMapping("/updatedepartment/{departmentId}")
	public String updateDepartment(@PathVariable("departmentId") Department department, Integer departmentId) {
		departmentService.update(department);
		return "updatedepartment";
	}

	@RequestMapping("/updatestore/{storeId}")
	public String updateStore(@PathVariable("storeId") Store store, Integer storeId) {
		storeService.update(store);
		return "updatestore";
	}

}
