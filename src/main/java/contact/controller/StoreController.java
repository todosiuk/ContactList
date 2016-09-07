package contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import contact.entity.Store;
import contact.service.StoreService;

@Controller
@RequestMapping("/store")
public class StoreController {

	@Autowired
	private StoreService storeService;

	@RequestMapping(value = "/stores", method = RequestMethod.GET)
	public String getStores(Model model) {
		List<Store> stores = storeService.read();
		model.addAttribute("stores", stores);
		return "storespage";
	}

	@RequestMapping(value = "/stores/add", method = RequestMethod.POST)
	public String getAdd(Model model) {
		model.addAttribute("storeAttribute", new Store());
		return "addstorepage";
	}

	@RequestMapping(value = "/stores/add", method = RequestMethod.POST)
	public String addStore(@ModelAttribute("storeAttribute") Store store) {
		storeService.create(store);
		return "addedstorepage";
	}

	public String delete(@RequestParam(value = "id", required = true) Integer id, Model model) {
		storeService.delete(id);
		model.addAttribute("id", id);
		return "deletedstorepage";
	}
	
	

}
