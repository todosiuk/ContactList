package contact.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import contact.dto.StoreDTO;
import contact.entity.Department;
import contact.entity.Store;
import contact.service.DepartmentServiceImpl;
import contact.service.StoreServiceImpl;

/**
 * ���������� ������������ ������� �� �������.
 * 
 * @author todosuk
 *
 */
@Controller
@RequestMapping("/store")
public class StoreController {

	@Autowired
	private StoreServiceImpl storeService;

	/**
	 * ����� ���������� �������� storesPage.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/stores", method = RequestMethod.GET)
	public String getStores(Model model) {
		// �������� ��� �������
		List<Store> stores = storeService.read();
		// ��������� ������
		model.addAttribute("stores", stores);
		// ���������� ��������
		return "storesPage";
	}

	/**
	 * ����� ���������� �������� � ������ ��� ���������� ������ �������.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/stores/add", method = RequestMethod.GET)
	public String getAdd(Model model) {
		model.addAttribute("storeAttribute", new Store());
		return "addStorePage";
	}

	/**
	 * ����� ��������� ����� ������.
	 * 
	 * @param store
	 * @return
	 */
	@RequestMapping(value = "/stores/add", method = RequestMethod.POST)
	public String postAdd(@ModelAttribute("storeAttribute") Store store) {
		// �������� ������-����
		storeService.create(store);
		return "addedStorePage";
	}

	/**
	 * ����� ������� ������ �� id.
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/stores/delete", method = RequestMethod.GET)
	public String delete(@RequestParam(value = "id", required = true) Integer id, Model model) {
		storeService.delete(id);
		model.addAttribute("id", id);
		return "deletedStorePage";
	}

	/**
	 * ����� ���������� �������� � ������ ��������������.
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/stores/edit", method = RequestMethod.GET)
	public String getUpdate(@RequestParam(value = "id", required = true) Integer id, Model model) {
		model.addAttribute("storeAttribute", storeService.getStoreFromId(id));
		return "editStorePage";
	}

	/**
	 * ����� ��������� ������.
	 * 
	 * @param store
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/stores/edit", method = RequestMethod.POST)
	public String saveUpdate(@ModelAttribute("storeAttribute") Store store,
			@RequestParam(value = "id", required = true) Integer id, Model model) {
		// �������� Id
		store.setId(id);
		storeService.update(store);
		model.addAttribute("id", id);
		return "editedStorePage";
	}

	/**
	 * ����� ���������� ������ ���� ������������� ��� ����������� ��������.
	 * 
	 * @param storeId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/stores/record", method = RequestMethod.GET)
	public String getDepForStore(@RequestParam(value = "id", required = true) Integer storeId, Model model) {
		// ���������� ������� ������.
		List<StoreDTO> storeDTO = new ArrayList<StoreDTO>();
		// �������� �������
		Store store = new Store();
		// �������� DTO
		StoreDTO dto = new StoreDTO();
		dto.setId(store.getId());
		dto.setCity(store.getCity());
		dto.setDepList(storeService.getDepartmentsForStore(storeId));
		// ���������� � ������
		storeDTO.add(dto);
		model.addAttribute("stores", storeDTO);
		return "record";
	}
}
