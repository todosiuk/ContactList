package contact.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import contact.entity.Store;
import contact.service.ServiceInt;

@Controller
@RequestMapping(value="/")
public class AppController {

	@Autowired
	private ServiceInt<Store, ?> storeService;

	@RequestMapping(value="/store")
	public ModelAndView store() {
		return new ModelAndView("formstore", "command", new Store());
	}
	
	@RequestMapping(value="/createStore", method = RequestMethod.POST)
	public ModelAndView createStore(@ModelAttribute("viewstore") Store store) {
		storeService.create(store);
		return new ModelAndView("redirect:/viewstore");
	}
	
	@RequestMapping(value="/viewstore" ) 
	public ModelAndView viewStore(){
		List<Store> list = storeService.read();
		return new ModelAndView("viewstore", "list", list);
	}

	

	

}