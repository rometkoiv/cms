package cms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cms.backend.model.Customer;
import cms.backend.service.AccountManagerService;
import cms.backend.service.CustomerService;
import cms.frontend.MainView;
import cms.log.cmsLogger;

@Controller
@RequestMapping("/customerManager/**")
public class customerController {
	@Autowired
	private AccountManagerService accountManager;
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getGroups(){
		MainView mv = new MainView(accountManager);
		mv.addObject("customerList",customerService.getList());
		return mv;
	}
	
	
	@RequestMapping(value = "/customerManager/{id}")
	public ModelAndView getCustomer(@PathVariable("id") Long id){
		MainView mv = new MainView(accountManager);
		Customer selectCustomer = new Customer();
		mv.addObject("customerList",customerService.getList());
		if(id!=0){selectCustomer = customerService.getCustomerByID(id);
		if(selectCustomer!=null){
		mv.addObject("customerID",selectCustomer.getCustomer());
		}
		}
		mv.addObject("customer",selectCustomer);
		mv.setViewName("customerManager");
		return mv;
	
	}
	
	@RequestMapping(value = "/customerManager/{id}/delete")
	public ModelAndView deleteCustomer(@PathVariable Long id){
		MainView mv = new MainView(accountManager);
		if(id !=null  ){
        if(customerService.remove(id)){
        	mv.addObject("info","Eemladatud");
        }else{
        	mv.addObject("error","Ei saanud kustutada");
        }
       
		}
		else{
			mv.addObject("error","Ei leidnud ID");
		}
		
		mv.addObject("customerList",customerService.getList());
		mv.setViewName("customerManager");
		return mv;
	
	}
	
	@RequestMapping("/customerManager/new")
	public ModelAndView insertCustomer(Customer newCustomer){
		MainView mv = new MainView(accountManager);
		mv.addObject("customerList",customerService.getList());
		mv.addObject("customer",newCustomer);
		mv.setViewName("customerManager");
		return mv;
	
	}
	
	@RequestMapping(value = "/customerManager/{id}",method = RequestMethod.POST, params="customer")
	public ModelAndView updateCustomer(@RequestParam("customer") Long id,  @ModelAttribute("customer") @Valid final Customer updatableCustomer, final BindingResult result){
		MainView mv = new MainView(accountManager);
		
		if (result.hasErrors()) { 
			cmsLogger.Log("Klient valideerimise vead","");
			mv.addObject("customer",updatableCustomer);
			mv.addObject("error","ei valideeru");
			
		}
		else
		{
		
			mv.addObject("info","Salvestatud");
			mv.addObject("customer",customerService.update(updatableCustomer,(long) mv.getModel().get("currentEployeeID")));
		}
		
		mv.addObject("customerList",customerService.getList());
		
		mv.setViewName("customerManager");
		return mv;
	
	}
	
	
	
}
