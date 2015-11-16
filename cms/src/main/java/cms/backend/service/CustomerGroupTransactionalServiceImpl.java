package cms.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import cms.backend.dao.CustomerGroupDAO;
import cms.backend.model.CustomerGroup;
import cms.log.cmsLogger;

@Service("CustomerGroupTransactionalService")
public class CustomerGroupTransactionalServiceImpl implements CustomerGroupTransactionalService
{
	@Autowired
	private CustomerGroupDAO customergroupDAO;
	@Autowired
	private Validator validator;
	
	
	public CustomerGroup getCustomerGroupByID(Long id) {
	
		
		CustomerGroup customergroup = null;
		try {
           customergroup = customergroupDAO.getCustomerGroupByID(id);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CustomerGroupTransactionalServiceImpl.getCustomerGroupByID():",ex.getMessage());
			
		}

		return customergroup;
	}
    
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public CustomerGroup update(CustomerGroup customergroup, Long upuser) {
	    try {
           return customergroupDAO.update(customergroup,upuser);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CustomerGroupTransactionalService.update():",ex.getMessage());
			return null;
		}

		
	}

	public List<CustomerGroup> getList(Long customer) {
		List<CustomerGroup> customergroups = null;
		try {
			
			customergroups = customergroupDAO.getList(customer);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CustomerGroupTransactionalService.getList():",ex.getMessage());
			
		}

		return customergroups;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(Long id) {
	boolean success = true;
		try {
			
			customergroupDAO.remove(id);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CustomerGroupTransactionalService.remove("+String.valueOf(id)+"):",ex.getMessage());
			success = false;
		}
		return success;
	}

	
	
}
