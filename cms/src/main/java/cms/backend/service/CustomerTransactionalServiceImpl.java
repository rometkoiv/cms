package cms.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import cms.backend.dao.CustomerDAO;
import cms.backend.model.Customer;
import cms.log.cmsLogger;

@Service("CustomerTransactionalService")
public class CustomerTransactionalServiceImpl implements CustomerTransactionalService
{
	@Autowired
	private CustomerDAO customerDAO;
	@Autowired
	private Validator validator;
	
	
	public Customer getCustomerByID(Long id) {
	
		
		Customer customer = null;
		try {
		  //cmsLogger.Inform("CustomerTransactionalService", "getCustomerByID(START)");
           customer = customerDAO.getCustomerByID(id);
           //cmsLogger.Inform("CustomerTransactionalService", "getCustomerByID(END)");
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CustomerTransactionalServiceImpl.getCustomerByID():",ex.getMessage());
			
		}

		return customer;
	}
    
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Customer update(Customer customer, Long upuser) {
	    try {
           return customerDAO.update(customer,upuser);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CustomerTransactionalService.update():",ex.getMessage());
			return null;
		}

		
	}

	public List<Customer> getList() {
		List<Customer> customers = null;
		try {
			
			customers = customerDAO.getList();
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CustomerTransactionalService.getList():",ex.getMessage());
			
		}

		return customers;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(Long id) {
	boolean success = true;
		try {
			
			customerDAO.remove(id);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CustomerTransactionalService.remove("+String.valueOf(id)+"):",ex.getMessage());
			success = false;
		}
		return success;
	}

	
	
}
