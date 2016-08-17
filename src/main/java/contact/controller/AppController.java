package contact.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import contact.entity.Store;
import contact.service.ServiceInt;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	private ServiceInt<Store, ?> storeService;

	@RequestMapping(value="/empform")
	public String showForm() {
		return "redirect:empform";//new ModelAndView("empform", "command", new Store());
	}

	@RequestMapping("/create")
	public ModelAndView createStore(@ModelAttribute("store") Store store) {
		storeService.create(store);
		return new ModelAndView("redirect:/viewemp");
	}

	@RequestMapping("/viewemp")  
	public ModelAndView viewemp() {
		List<Store> list = storeService.read();
		return new ModelAndView("viewemp", "list", list);
	}

}