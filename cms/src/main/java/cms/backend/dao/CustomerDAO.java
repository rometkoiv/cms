package cms.backend.dao;

import java.util.List;

import cms.backend.model.Customer;

public interface CustomerDAO {
	public Customer getCustomerByID(Long id) throws DaoException;
	public Customer update(Customer customer, Long upuser) throws DaoException;
	public List<Customer> getList() throws DaoException ;
	boolean remove (Long id) throws DaoException ;
	
}
