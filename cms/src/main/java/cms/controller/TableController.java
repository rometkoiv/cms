package cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cms.backend.model.CommDevice;
import cms.backend.model.CstAddress;
import cms.backend.model.Customer;

@Controller
@RequestMapping("/table/**")
public class TableController {
	@RequestMapping(value = "/table/{name}",method=RequestMethod.GET)
	public ModelAndView getTable(@PathVariable("name") String name){
		ModelAndView mv = new ModelAndView();
		if(name !=null)
		
		switch(name){
		case "Customer":
			Customer customer = new Customer();
			mv.addObject("Customer",customer);
			mv.setViewName("table/customer");
			break;
		case "Address":
			
			CstAddress address = new CstAddress();
			mv.addObject("CstAddress",address);
			mv.setViewName("table/address");
			break;
		case "Commdevice":
			CommDevice commdevice = new CommDevice();
			mv.addObject("commdevice",commdevice);
			mv.setViewName("table/commdevice");
			break;
		default:
			mv.setViewName("blank");
		}
		
		return mv;
	
	}
}
