package cms.controller;

import java.beans.PropertyEditorSupport;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cms.backend.model.Customer;
import cms.backend.service.AccountManagerService;
import cms.backend.service.CustomerService;
import cms.frontend.MainView;
import cms.frontend.model.JsonResponse;


@Controller
@RequestMapping("/ajax/Customer/**")
public class AJAXcustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AccountManagerService accountManagerService;
	
   
	
	@RequestMapping(value = "/ajax/Customer/one/{id}", method = RequestMethod.GET,produces = "application/json")
	public @ResponseBody
	Customer getCustomer(@PathVariable("id") Long id) {
		//cmsLogger.Inform("AJAXcustomerController", "getCustomer(START)");
		Customer customer = customerService.getCustomerByID(id);
		//cmsLogger.Inform("AJAXcustomerController", "getCustomer(END)");
		return customer;

	}
	
	@RequestMapping(value = "/ajax/Customer/Delete/{id}", method = RequestMethod.GET,produces = "application/json")
	public @ResponseBody
	JsonResponse deleteCustomer(@PathVariable("id") Long id) {
		boolean success = false;
		JsonResponse resp = new JsonResponse();
		if(id != null){
		success = customerService.remove(id);
           if(success){
        	   resp.setStatus("OK");
        	   resp.setResult("Kustutatud");
           }
           else{
        	   resp.setStatus("ERROR");
        	   resp.setResult("Viga kustutamisel");
           }
		}
		else{
			resp.setStatus("ERROR");
			resp.setResult("Viga päringus");
		}
		
		
		return resp;
		
	}
	
	@RequestMapping(value = "/ajax/Customer/getAll", method = RequestMethod.GET,produces = "application/json")
	public @ResponseBody
	List<Customer> getAllCustomer() {
		//System.out.println("listtest");
		return customerService.getList();
		 

	}
	
	

	
	@RequestMapping(value = "/ajax/Customer",method = RequestMethod.POST,produces = "application/json")
	public @ResponseBody
	JsonResponse updateCustomer(@RequestBody @Valid Customer customer, BindingResult result)
	{
		
		
		//System.out.println("Submited User Data : \n"+customer.getCustomer());
		JsonResponse resp = new JsonResponse();
		if (result.hasErrors()) { 
			resp.setStatus("ERROR");
			resp.setResult(result.getAllErrors());
			//System.out.println("VEAD: "+ result.toString());
			//System.out.println("VEAD2: "+ customer.getCustomer());
			
		}
		else
		{
			MainView mv = new MainView(accountManagerService);
			resp.setStatus("OK");
			resp.setResult(customerService.update(customer,(long) mv.getModel().get("currentEployeeID")));
			
		}
		return resp;
	}
	
	@InitBinder
	 protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
	     binder.registerCustomEditor(long.class, new PropertyEditorSupport() {
	     @Override
	     public void setAsText(String text) {
	    	 if(text.trim().length()==0){
	    		 text="0";
	    	 }
	         long ch = Long.parseLong(text);
	         setValue(ch);
	     }
	     });
	    
	 }
}
