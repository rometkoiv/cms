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

import cms.backend.model.CommDevAndType;
import cms.backend.model.CommDevice;
import cms.backend.service.CommDeviceAndTypeService;
import cms.backend.service.CommDeviceService;
import cms.frontend.model.JsonResponse;

@Controller
@RequestMapping("/ajax/CommDevice/**")
public class AJAXcommDeviceController {

	@Autowired
	private CommDeviceService commdeviceService;
	
	@Autowired
	private CommDeviceAndTypeService commdeviceandtypeService;
	
	//ID järgi
	@RequestMapping(value = "/ajax/CommDevice/one/{id}", method = RequestMethod.GET,produces = "application/json")
	public @ResponseBody
	CommDevAndType getCommDevice(@PathVariable("id") Long id) {
		CommDevAndType single = commdeviceandtypeService.getCommDeviceByID(id);
		return single;

	}
	
	
	//järjesta
	@RequestMapping(value = "/ajax/CommDevice/Order/{id}/{order}", method = RequestMethod.GET, 	produces = "application/json")
	public @ResponseBody
	JsonResponse setOrder(@PathVariable("id") Long id,@PathVariable("order") int order ) {
		JsonResponse resp = new JsonResponse();
		
		CommDevice currentCommDevice = commdeviceService.getCommDeviceByID(id);
		
	    if(id !=null){
	    	currentCommDevice = commdeviceService.update(currentCommDevice, order);
			
           if(currentCommDevice != null){
        	   resp.setStatus("OK");
        	   resp.setResult("Järjekord muudetud");
           }
           else{
        	   resp.setStatus("ERROR");
        	   resp.setResult("Viga andmete salvestamisel");
           }
		}
		else{
			resp.setStatus("ERROR");
			resp.setResult("Viga päringus");
		}
		
		
		return resp;
	}
	
		
	@RequestMapping(value = "/ajax/CommDevice/CustomerAll/{customer}", method = RequestMethod.GET, 	produces = "application/json")
	public @ResponseBody
	List<CommDevAndType> getCommAll(@PathVariable("customer") Long customer ) {
		return commdeviceandtypeService.getList(customer);
	}
	
	@RequestMapping(value = "/ajax/CommDevice/Customer/{customer}",method = RequestMethod.POST,produces = "application/json")
	public @ResponseBody
	JsonResponse updateCommDevice(@PathVariable("customer") Long customer,@RequestBody @Valid CommDevAndType commdevandtype, BindingResult result)
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
			if(commdeviceandtypeService.update(commdevandtype,customer,0)!=null){
				resp.setStatus("OK");
				resp.setResult("Salvestatud");	
			}
			else{
			resp.setStatus("ERROR");
			resp.setResult("Salvestamisel Juhtus mingi tõrge");}
		}
		}else{
			resp.setStatus("ERROR");
			resp.setResult("Klienti pole valitud");
		}
		return resp;
	}
	
	//kustuta
		@RequestMapping(value = "/ajax/CommDevice/DeleteMultiple/{list}", method = RequestMethod.GET, 	produces = "application/json")
		public @ResponseBody
		JsonResponse deleteCommDevice(@PathVariable("list") String list ) {
			JsonResponse resp = new JsonResponse();
			String error = "";
			boolean success = false;
			if(list !=null){
				
				if(list.contains(",")){
				for(String s : list.split(",")){
					if(s!= null && !s.isEmpty()){
				      success = commdeviceService.remove(Long.parseLong(s.trim()));
					  if(success !=true){
						  error += " " + s +" ";
					  }
					}
				}
				}else{
					success = commdeviceService.remove(Long.parseLong(list.trim()));
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
