package cms.backend.dao;

import java.util.List;

import cms.backend.model.CustomerGroup;

public interface CustomerGroupDAO {
	public CustomerGroup getCustomerGroupByID(Long id) throws DaoException;
	public CustomerGroup update(CustomerGroup customergroup, Long upuser) throws DaoException;
	public List<CustomerGroup> getList(Long customer) throws DaoException ;
	boolean remove (Long id) throws DaoException ;
	
}
