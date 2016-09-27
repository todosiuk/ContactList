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
 * Контроллер обрабатывает запросы от маркета.
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
	 * Метод возвращает страницу storesPage.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/stores", method = RequestMethod.GET)
	public String getStores(Model model) {
		// Получаем все маркеты
		List<Store> stores = storeService.read();
		// Добавляем модель
		model.addAttribute("stores", stores);
		// Возвращаем страницу
		return "storesPage";
	}

	/**
	 * Метод возвращает страницу с формой для добавления нового маркета.
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
	 * Метод добавляет новую запись.
	 * 
	 * @param store
	 * @return
	 */
	@RequestMapping(value = "/stores/add", method = RequestMethod.POST)
	public String postAdd(@ModelAttribute("storeAttribute") Store store) {
		// Вызываем сервис-слой
		storeService.create(store);
		return "addedStorePage";
	}

	/**
	 * Метод удаляет запись по id.
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
	 * Метод возвращает страницу с формой редактирования.
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
	 * Метод обновляет запись.
	 * 
	 * @param store
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/stores/edit", method = RequestMethod.POST)
	public String saveUpdate(@ModelAttribute("storeAttribute") Store store,
			@RequestParam(value = "id", required = true) Integer id, Model model) {
		// Передаем Id
		store.setId(id);
		storeService.update(store);
		model.addAttribute("id", id);
		return "editedStorePage";
	}

	/**
	 * Метод возвращает список всех департаментов для конкретного магазина.
	 * 
	 * @param storeId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/stores/record", method = RequestMethod.GET)
	public String getDepForStore(@RequestParam(value = "id", required = true) Integer storeId, Model model) {
		// Подготовка объекта модели.
		List<StoreDTO> storeDTO = new ArrayList<StoreDTO>();
		// Создание объекта
		Store store = new Store();
		// Создание DTO
		StoreDTO dto = new StoreDTO();
		dto.setId(store.getId());
		dto.setCity(store.getCity());
		dto.setDepList(storeService.getDepartmentsForStore(storeId));
		// Добавление в список
		storeDTO.add(dto);
		model.addAttribute("stores", storeDTO);
		return "record";
	}
}
