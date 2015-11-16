package cms.backend.service;

import java.util.List;

import cms.backend.model.CustomerGroup;


public interface CustomerGroupTransactionalService {
	public CustomerGroup getCustomerGroupByID(Long id);
	public CustomerGroup update(CustomerGroup customergroup, Long upuser);
	public List<CustomerGroup> getList(Long customer);
	boolean remove (Long id);
	
}
