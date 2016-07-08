package contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import contact.entity.Department;
import contact.entity.Store;
import contact.service.DepartmentService;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@RequestMapping("/empform")
	public ModelAndView showform() {
		return new ModelAndView("empform", "command", new Store());

	}

	@RequestMapping("/depdelete")
	public ModelAndView delete(@PathVariable int id) {
		departmentService.delete(id);
		return new ModelAndView("redirect:/depdelete");
	}

	@RequestMapping("/depupdate")
	public ModelAndView update(@PathVariable int id) {
		Department department = departmentService.getDepartmentFromId(id);
		return new ModelAndView("depupdform", "command", department);
	}

	@RequestMapping("/depread")
	public ModelAndView read() {
		List<Department> listdep = departmentService.read();
		return new ModelAndView("viewdep", "listdep", listdep);
	}

}
