package cms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cms.backend.model.CstAddress;
import cms.backend.model.Customer;
import cms.backend.service.AccountManagerService;
import cms.backend.service.CstAddressService;
import cms.backend.service.CustomerService;
import cms.frontend.MainView;
import cms.frontend.model.JsonResponse;

@Controller
@RequestMapping("/ajax/Address/**")
public class AJAXaddressController {

	@Autowired
	private CstAddressService addressService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AccountManagerService accountManagerService;
	
	//ID järgi
	@RequestMapping(value = "/ajax/Address/one/{id}", method = RequestMethod.GET,produces = "application/json")
	public @ResponseBody
	CstAddress getAdress(@PathVariable("id") Long id) {
		CstAddress single = addressService.getCstAddressByID(id,null);
		return single;

	}
	//Kliendi peamine
	@RequestMapping(value = "/ajax/Address/Customer/{customer}", method = RequestMethod.GET, 	produces = "application/json")
	public @ResponseBody
	CstAddress getAddress(@PathVariable("customer") Long customer ) {
		return addressService.getCstAddressByID(null,customer);
	}
	
	//aktiveeri
	@RequestMapping(value = "/ajax/Address/Customer/{customer}/Active/{id}", method = RequestMethod.GET, 	produces = "application/json")
	public @ResponseBody
	JsonResponse setActiveAddress(@PathVariable("customer") Long customer,@PathVariable("id") Long id ) {
		JsonResponse resp = new JsonResponse();
		
		CstAddress currentAddress = addressService.getCstAddressByID(id, customer);
		
	    if(currentAddress != null && id != null && currentAddress.getAddressType() != null && currentAddress.getAddressType() !=1){
	    	//System.out.println("Olen kohal");
	    	currentAddress.setAddressType(new Long(1));
			MainView mv = new MainView(accountManagerService);
			currentAddress = addressService.update(currentAddress, (long) mv.getModel().get("currentEployeeID"));
			
           if(currentAddress != null){
        	   resp.setStatus("OK");
        	   resp.setResult("Aadress aktiveeritud");
           }
           else{
        	   resp.setStatus("ERROR");
        	   resp.setResult("Viga andmete salvestamisel");
           }
		}
		else{
			resp.setStatus("ERROR");
			resp.setResult("Kas aadress on juba aktiivne või on viga päringus");
		}
		
		
		return resp;
	}
	
	@RequestMapping(value = "/ajax/Address/CustomerAll/{customer}", method = RequestMethod.GET, 	produces = "application/json")
	public @ResponseBody
	List<CstAddress> getAddressAll(@PathVariable("customer") Long customer ) {
		return addressService.getList(customer);
	}
	
	@RequestMapping(value = "/ajax/Address/Customer/{customer}",method = RequestMethod.POST,produces = "application/json")
	public @ResponseBody
	JsonResponse updateAddress(@PathVariable("customer") Long customer,@RequestBody @Valid CstAddress address, BindingResult result)
	{
		JsonResponse resp = new JsonResponse();
		//System.out.println("Submited Address Data : \n"+address.getAddress());
		
		if(customer != 0){
		
		if (result.hasErrors()) { 
			resp.setStatus("ERROR");
			resp.setResult(result.getAllErrors());
			//System.out.println("VEAD: "+ result.toString());
			//System.out.println("VEAD2: "+ customer.getCustomer());
			
		}
		else
		{
			MainView mv = new MainView(accountManagerService);
			
			Customer selectCustomer = customerService.getCustomerByID(customer);
			address.setCustomerBean(selectCustomer);
			if(addressService.update(address,(long) mv.getModel().get("currentEployeeID"))!=null){
				resp.setStatus("OK");
				resp.setResult("Aadress salvestatud");	
			}
			else{
			resp.setStatus("ERROR");
			resp.setResult("Salvestamisel Juhtus mingi tõrge");}
		}
		}else{
			resp.setStatus("ERROR");
			if (result.hasErrors()) { 
				resp.setResult(result.getAllErrors());
			}
			else{
			   resp.setResult("Klienti pole valitud");
			}
		}
		return resp;
	}
	
	//kustuta
			@RequestMapping(value = "/ajax/Address/DeleteMultiple/{list}", method = RequestMethod.GET, 	produces = "application/json")
			public @ResponseBody
			JsonResponse deleteAddress(@PathVariable("list") String list ) {
				JsonResponse resp = new JsonResponse();
				String error = "";
				boolean success = false;
				if(list !=null){
					
					if(list.contains(",")){
					for(String s : list.split(",")){
						if(s!= null && !s.isEmpty()){
					      success = addressService.remove(Long.parseLong(s.trim()));
						  if(success !=true){
							  error += " " + s +" ";
						  }
						}
					}
					}else{
						success = addressService.remove(Long.parseLong(list.trim()));
						  if(success!=true){
							  error += " " + list +" ";
						  }
					}
		           if(error.length() == 0){
		        	   resp.setStatus("OK");
		        	   resp.setResult("Kustutatud");
		           }
		           else{
		        	   resp.setStatus("ERROR");
		        	   resp.setResult("Viga kustutamisel: "+error);
		           }
				}
				else{
					resp.setStatus("ERROR");
					resp.setResult("Viga päringus");
				}
				
				
				return resp;
			}
}
