package cms.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cms.backend.model.CommDevice;
import cms.backend.model.CstAddress;
import cms.backend.model.Customer;
import cms.backend.model.CustomerGroup;
import cms.log.cmsLogger;

@Service("CustomerService")
public class CustomerService {
	
	@Autowired
	private CustomerTransactionalService customerTransactionalService ;
	
	@Autowired
	private CstAddressService cstAddressService;
	
	@Autowired
	private CustomerGroupTransactionalService customergroupTransactionalService;
	
	@Autowired
	private CommDeviceService commDeviceService;
	
	
	public Customer getCustomerByID(Long id){
		Customer customer = null;
		try {
			//cmsLogger.Inform("CustomerService", "getCustomerByID(START)");
			customer=customerTransactionalService.getCustomerByID(id);
			//cmsLogger.Inform("CustomerService", "getCustomerByID(END)");
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CustomerTransactionalService.getUserByUserName():",ex.getMessage());
		}

		return customer;
	}
	
	public Customer update(Customer customer, Long upuser){
		try {
			customer=customerTransactionalService.update(customer,upuser);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CustomerTransactionalService.update():",ex.getMessage());
		}

		return customer;
	}
	public List<Customer> getList(){
		List<Customer> customerList = null;
		try {
			customerList=customerTransactionalService.getList();
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CustomerTransactionalService.getUsers():",ex.getMessage());
		}
		return customerList;
	}
	
	public boolean remove(Long id){
		boolean success = true;
		try {
			//Grupid
			List<CustomerGroup> cg = customergroupTransactionalService.getList(id);
			if(cg != null && !cg.isEmpty() && success){
				for(CustomerGroup g:cg){
				  success =  customergroupTransactionalService.remove(g.getCustomerGroup());
				}
			}
			//Addressid
			List<CstAddress> cstList = cstAddressService.getList(id);
			if(cstList != null && !cstList.isEmpty() && success){
				for(CstAddress cst:cstList){
				  success =  cstAddressService.remove(cst.getCstAddress());
				}
			}
			//Deviced
			List<CommDevice> commList = commDeviceService.getList(id);
			if(commList != null && !commList.isEmpty() && success){
				for(CommDevice comm:commList){
				  success =  commDeviceService.remove(comm.getCommDevice());
				}
			}
			//Viimasena kunde ise
			if(success){
			   success = customerTransactionalService.remove(id);
			}
		}

		catch(Exception ex)
		{
			success=false;
			cmsLogger.Log("CustomerTransactionalService.remove():",ex.getMessage());
		}

		return success;
	}
	
}
