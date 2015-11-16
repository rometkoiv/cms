package cms.backend.service;

import java.util.List;

import cms.backend.model.Customer;


public interface CustomerTransactionalService {
	public Customer getCustomerByID(Long id);
	public Customer update(Customer customer, Long upuser);
	public List<Customer> getList();
	boolean remove (Long id);
	
}
