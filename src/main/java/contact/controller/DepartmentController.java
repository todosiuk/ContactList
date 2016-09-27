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

/**
 *  онтроллер обрабатывает запросы от департаментов.
 * 
 * @author todosuk
 *
 */
@Controller
@RequestMapping("/dep")
public class DepartmentController {

	@Autowired
	private StoreServiceImpl storeService;
	@Autowired
	private DepartmentServiceImpl depService;

	/**
	 * ћетод возвращает страницу с формой дл€ создани€ нового департамента.
	 * 
	 * @param storeId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAdd(@RequestParam(value = "id", required = true) Integer storeId, Model model) {
		Department department = new Department();
		department.setStore(storeService.getStoreFromId(storeId));
		model.addAttribute("departmentAttribute", department);
		return "addDepartmentPage";
	}

	/**
	 * ћетод добавл€ет новый департамент.
	 * 
	 * @param storeId
	 * @param department
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String postAdd(@RequestParam(value = "id", required = true) Integer storeId,
			@ModelAttribute("departmentAttribute") Department department) {
		depService.create(storeId, department);
		return "addedDepartmentPage";
	}

	/**
	 * ћетод удал€ет департамент по его id.
	 * 
	 * @param depId
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam(value = "id", required = true) Integer depId) {
		depService.delete(depId);
		return "deletedDepartmentPage";
	}

	/**
	 * ћетод возвращает страницу с формой дл€ редактировани€ департамента.
	 * 
	 * @param storeId
	 * @param depId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String getUpdate(@RequestParam(value = "storeId", required = true) Integer storeId,
			@RequestParam("depId") Integer depId, Model model) {
		Department department = new Department();
		department.setStore(storeService.getStoreFromId(storeId));
		model.addAttribute("storeId", storeId);
		model.addAttribute("departmentAttribute", depService.getDepartmentFromId(depId));
		return "editDepartmentPage";
	}

	/**
	 * ћетод обновл€ет департамент.
	 * 
	 * @param depId
	 * @param storeId
	 * @param department
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String saveUpdate(@RequestParam(value = "depId", required = true) Integer depId,
			@RequestParam(value = "storeId", required = true) Integer storeId,
			@ModelAttribute("departmentAttribute") Department department) {
		department.setId(depId);
		depService.update(department);
		return "editedDepPage";
	}

}
