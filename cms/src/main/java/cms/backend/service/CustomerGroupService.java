package cms.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cms.backend.model.CGroup;
import cms.backend.model.CustomerGroup;
import cms.backend.model.GroupWithCustomer;
import cms.utils.stringToArrayList;
import cms.log.cmsLogger;

@Service("CustomerGroupService")
public class CustomerGroupService {
	
	@Autowired
	private CGroupService cgroupService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerGroupTransactionalService customergroupTransactionalService ;
	
	public CustomerGroup getCustomerGroupByID(Long id){
		CustomerGroup customergroup = null;
		try {
			customergroup=customergroupTransactionalService.getCustomerGroupByID(id);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CustomerGroupTransactionalService.getUserByUserName():",ex.getMessage());
		}

		return customergroup;
	}
	public boolean editList(Long customer,String list, Long upuser){
		boolean success = true;
		try {
			
			ArrayList<Long> checkList=null;
					if(!list.equals("CLEARALL")){
						checkList = stringToArrayList.convert(list,",");
						}
			
			List<GroupWithCustomer>	groupsAvailable = getList(customer);
			if(groupsAvailable != null &&! groupsAvailable.isEmpty()){
			 for(GroupWithCustomer cg : groupsAvailable){	
				
				 if(checkList != null && checkList.contains(cg.getGroup()) && cg.getCustomer() == null){
					 
					CustomerGroup newGroup = new CustomerGroup();
					newGroup.setCGroup(cgroupService.getCGroupByID(cg.getGroup()));
					newGroup.setCustomerBean(customerService.getCustomerByID(customer));
					update(newGroup, upuser);	 
					 
				 }
				 if(checkList != null && !checkList.contains(cg.getGroup()) && cg.getCustomer() != null){
					 remove(cg.getLink());
				 }
				 if(checkList == null && cg.getCustomer() != null){
					// System.out.println("Eemaldan");
					 remove(cg.getLink());
				 }
		      
			   }
			}
		}

		catch(Exception ex)
		{
			success= false;
			cmsLogger.Log("CustomerGroupTransactionalService.getUserByUserName():",ex.getMessage());
		}

		
		return success;
	}
	
	public CustomerGroup update(CustomerGroup customergroup, Long upuser){
		try {
			customergroup=customergroupTransactionalService.update(customergroup,upuser);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CustomerGroupTransactionalService.update():",ex.getMessage());
		}

		return customergroup;
	}
	public List<GroupWithCustomer> getList(Long customer){
		List<CustomerGroup> customergroupList = null;
		List<CGroup> allGroups = null;
		List<GroupWithCustomer> rList = new ArrayList<GroupWithCustomer>();
		try {
			customergroupList=customergroupTransactionalService.getList(customer);
			allGroups = cgroupService.getList();
			if(allGroups!= null && !allGroups.isEmpty()){
			for(CGroup g: allGroups){
				GroupWithCustomer cm = new GroupWithCustomer();
				cm.setName(g.getName());
				cm.setGroup(g.getCGroup());
				cm.setDescription(g.getDescription());
				//Kui on grupis
				if(customergroupList!= null && !customergroupList.isEmpty()){
				   	for(CustomerGroup c: customergroupList){
				   		if(c.getCGroup().getCGroup() == g.getCGroup()){
				   			cm.setCustomer(customer);
				   			cm.setCreated(c.getCreated());
				   			cm.setLink(c.getCustomerGroup());
				   		}
				   	}
				}
				rList.add(cm);
			 }
			}
		}

		catch(Exception ex)
		{
			rList= null;
			cmsLogger.Log("CustomerGroupTransactionalService.getUsers():",ex.getMessage());
		}
		return rList;
	}
	
	public boolean remove(Long id){
		boolean success = true;
		try {
			success = customergroupTransactionalService.remove(id);
		}

		catch(Exception ex)
		{
			success=false;
			cmsLogger.Log("CustomerGroupTransactionalService.remove():",ex.getMessage());
		}

		return success;
	}
	
}
