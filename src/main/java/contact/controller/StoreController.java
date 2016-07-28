package contact.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import contact.entity.Store;
import contact.service.StoreService;

@Controller
public class StoreController {

	@Autowired
	private StoreService storeService;
	
	@RequestMapping({ "/", "/home", "/index" })
	public String home(Model model) {
		return "index";
	}

	@RequestMapping("/empform")
	public ModelAndView showform() {
		return new ModelAndView("empform", "command", new Store());
	}

	@RequestMapping("/storeadd")
	public ModelAndView create(@ModelAttribute("store") Store store) {
		storeService.create(store);
		return new ModelAndView("redirect:/storecreate");

	}

	@RequestMapping("/storedelete")
	public ModelAndView delete(@PathVariable int id) {
		storeService.delete(id);
		return new ModelAndView("redirect:/storedelete");
	}

	@RequestMapping("/storeupdate")
	public ModelAndView update(@PathVariable int id) {
		Store store = storeService.getStoreFromId(id);
		return new ModelAndView("storeupdform", "command", store);
	}

	@RequestMapping("/storeread")
	public ModelAndView read() {
		List<Store> liststore = storeService.read();
		return new ModelAndView("viewstore", "liststore", liststore);
	}

}
