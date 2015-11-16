package cms.backend.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import cms.backend.model.Customer;
import cms.log.cmsLogger;


@Repository
public class CustomerDAOJPAImpl implements CustomerDAO{
	@PersistenceContext
	private EntityManager em;

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	public Customer getCustomerByID(Long id) throws DaoException {
		
		Customer retCustomer = null;
		try {
		//cmsLogger.Inform("CustomerDAOJPAImpl", "getCustomerByID(START)");
		TypedQuery<Customer> qGetOne = em.createNamedQuery("Customer.findByID",Customer.class);
		qGetOne.setParameter("id", id);
		List<Customer> retList = qGetOne.getResultList();
		if(retList!= null && !retList.isEmpty())
		{
		   retCustomer =  retList.get(0);
		}
		//cmsLogger.Inform("CustomerDAOJPAImpl", "getCustomerByID(END)");
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CustomerDAOJPAImpl.getCustomerByID():",ex.getMessage());
			throw new DaoException(ex.getMessage(),ex);
			
		}
		return retCustomer;

	}


	
	public Customer update(Customer customer, Long upuser) throws DaoException {
		Customer retCustomer = null;
		try {
			if(customer.getCustomer() == 0){
				customer.setCreated(DAOUtils.getTimeStamp());
				customer.setCreatedBy(upuser);
			}
			else{
				retCustomer = em.find(Customer.class, customer.getCustomer());
				customer.setCreated(retCustomer.getCreated());
				customer.setCreatedBy(retCustomer.getCreatedBy());
			}
			customer.setUpdatedBy(upuser);
			customer.setUpdated(DAOUtils.getTimeStamp());
			
			
			
			retCustomer = em.merge(customer);
			retCustomer = em.find(Customer.class, retCustomer.getCustomer());
		
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CustomerDAOJPAImpl.update():",ex.getMessage());
			throw new DaoException(ex.getMessage(),ex);
			
		}
		return retCustomer;
	}

	
	public List<Customer> getList() throws DaoException {
		List<Customer> retCustomerList = null;
		try {
		TypedQuery<Customer> qfindAll = em.createNamedQuery("Customer.findAll",Customer.class);
		retCustomerList =  qfindAll.getResultList();
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CustomerDAOJPAImpl.getCustomer():",ex.getMessage());
			throw new DaoException(ex.getMessage(),ex);
			
		}
		return retCustomerList;
	}


	public boolean remove(Long id) throws DaoException {
		boolean success = true;
		try {
			Customer customer = this.getCustomerByID(id);
			em.remove(customer);
			}

			catch(Exception ex)
			{
				success= false;
				cmsLogger.Log("CustomerDAOJPAImpl.remove():",ex.getMessage());
				throw new DaoException(ex.getMessage(),ex);
							
		     }
		return success;
	}
	
}
