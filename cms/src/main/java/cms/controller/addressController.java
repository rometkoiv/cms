package cms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cms.backend.model.CstAddress;
import cms.backend.model.Customer;
import cms.backend.service.AccountManagerService;
import cms.backend.service.CstAddressService;
import cms.backend.service.CustomerService;
import cms.frontend.MainView;
import cms.log.cmsLogger;

@Controller
@RequestMapping("/customerManager/**")
public class addressController {
	@Autowired
	private AccountManagerService accountManager;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CstAddressService addressService;

	@RequestMapping(value = "/customerManager/{id}/address/{adressid}")
	public ModelAndView getCustomerAddresses
	  (@PathVariable("id") long id, @PathVariable("adressid") long addressid) {
		MainView mv = new MainView(accountManager);
		Customer selectCustomer = customerService.getCustomerByID(id);
		mv.addObject("customerList",customerService.getList());
		mv.addObject("customer",selectCustomer);
		mv.addObject("customerID",selectCustomer.getCustomer());
		
		CstAddress adr = new CstAddress();
		if(addressid!=0){adr = addressService.getCstAddressByID(addressid,null);}
		else{
			adr.setCustomerBean(selectCustomer);
		}
		
		mv.addObject("formaddress",adr);
		mv.addObject("addressList",addressService.getList(selectCustomer.getCustomer()));
		
		mv.setViewName("customerManager");
		return mv;
	}
	
	@RequestMapping(value = "/customerManager/{id}/address/{adressid}",method = RequestMethod.POST, params="cstAddress")
	public ModelAndView updateAddress(@PathVariable("id") long id, @PathVariable("adressid") long addressid,  @ModelAttribute("formaddress") @Valid final CstAddress updatableformaddress, final BindingResult result){
		MainView mv = new MainView(accountManager);
		Customer selectCustomer = customerService.getCustomerByID(id);
		if (result.hasErrors()) { 
			cmsLogger.Log("Aadressi valideerimise vead","");
			mv.addObject("formaddress",updatableformaddress);
			mv.addObject("error","ei valideeru");
			
		}
		else
		{
			updatableformaddress.setCustomerBean(selectCustomer);
			mv.addObject("info","Salvestatud");
			mv.addObject("formaddress",addressService.update(updatableformaddress,(long) mv.getModel().get("currentEployeeID")));
		}
		
		mv.addObject("customerList",customerService.getList());
		mv.addObject("customer",selectCustomer);
		mv.addObject("addressList",addressService.getList(selectCustomer.getCustomer()));
		mv.setViewName("customerManager");
		return mv;
	
	}
}
