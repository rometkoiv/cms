package cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cms.backend.model.GroupWithCustomer;
import cms.backend.service.AccountManagerService;
import cms.backend.service.CustomerGroupService;
import cms.frontend.MainView;
import cms.frontend.model.JsonResponse;

@Controller
@RequestMapping("/ajax/Group/**")
public class AJAXgroupController {

	@Autowired
	private CustomerGroupService customergroupService;
	
	@Autowired
	private AccountManagerService accountManager;
	//Vaata
	@RequestMapping(value = "/ajax/Group/Get/{customer}", method = RequestMethod.GET, 	produces = "application/json")
	public @ResponseBody
	List<GroupWithCustomer> getGroupsForCustmer(@PathVariable("customer") Long customer ) {
		return customergroupService.getList(customer);
	}
	
	
	
	
	//Muuda
	@RequestMapping(value = "/ajax/Group/Put/{customer}/{list}", method = RequestMethod.GET, 	produces = "application/json")
		public @ResponseBody
		JsonResponse modifyGroupsForCustomer(@PathVariable("customer") Long customer,@PathVariable("list") String list) {
			JsonResponse resp = new JsonResponse();
			boolean success = false;
			if(customer !=null){
			MainView mv = new MainView(accountManager);
			success =customergroupService.editList(customer, list, (long) mv.getModel().get("currentEployeeID"));
	           if(success){
	        	   resp.setStatus("OK");
	        	   resp.setResult("Muudetud");
	           }
	           else{
	        	   resp.setStatus("ERROR");
	        	   resp.setResult("Viga muutuste salvestamisel");
	           }
			}
			else{
				resp.setStatus("ERROR");
				resp.setResult("Viga päringus");
			}
			return resp;
		}
		
}
