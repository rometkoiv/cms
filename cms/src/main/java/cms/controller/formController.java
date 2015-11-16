package cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cms.backend.dao.DistinctSearchDAO;
import cms.backend.model.CommDevAndType;
import cms.backend.model.CstAddress;
import cms.backend.model.Customer;


@Controller
@RequestMapping("/form/**")
public class formController {
	@RequestMapping(value = "/form/{name}",method=RequestMethod.GET)
	public ModelAndView getForm(@PathVariable("name") String name){
		ModelAndView mv = new ModelAndView();
		
		if(name !=null)
		
		switch(name){
		case "Customer":
			Customer customer = new Customer();
			mv.addObject("Customer",customer);
			mv.setViewName("forms/customer");
			break;
		case "NewCustomer":
			Customer newcustomer = new Customer();
			mv.addObject("Customer",newcustomer);
			mv.setViewName("forms/newcustomer");
			break;
		
		case "CstAddress":
			
			CstAddress address = new CstAddress();
			mv.addObject("CstAddress",address);
			mv.setViewName("forms/cstaddress");
			break;
        case "CstAddressOnMain":
			
			CstAddress addressonmain = new CstAddress();
			mv.addObject("CstAddress",addressonmain);
			mv.setViewName("forms/maincstaddress");
			break;
		case "CommDevAndType":
			DistinctSearchDAO ds = new DistinctSearchDAO();
			CommDevAndType commdevice = new CommDevAndType();
			mv.addObject("CommDevAndType",commdevice);
			mv.addObject("typeList",ds.commDeviceTypeList());
			mv.setViewName("forms/commdevice");
			break;
		default:
			mv.setViewName("blank");
		}
		
		return mv;
	
	}
}
