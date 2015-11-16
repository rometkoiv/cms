package cms.backend.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import cms.backend.model.CustomerGroup;
import cms.log.cmsLogger;


@Repository
public class CustomerGroupDAOJPAImpl implements CustomerGroupDAO{
	@PersistenceContext
	private EntityManager em;

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	public CustomerGroup getCustomerGroupByID(Long id) throws DaoException {
		
		CustomerGroup retCustomerGroup = null;
		try {
		TypedQuery<CustomerGroup> qGetOne = em.createNamedQuery("CustomerGroup.findByID",CustomerGroup.class);
		qGetOne.setParameter("id", id);
		retCustomerGroup =  qGetOne.getSingleResult();
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CustomerGroupDAOJPAImpl.getCustomerGroupByID():",ex.getMessage());
			throw new DaoException(ex.getMessage(),ex);
			
		}
		return retCustomerGroup;

	}


	
	public CustomerGroup update(CustomerGroup customergroup, Long upuser) throws DaoException {
		CustomerGroup retCustomerGroup = null;
		try {
			if(customergroup.getCustomerGroup() == 0){
				customergroup.setCreated(DAOUtils.getTimeStamp());
				customergroup.setCreatedBy(upuser);
			}
			else{
				retCustomerGroup = em.find(CustomerGroup.class, customergroup.getCustomerGroup());
				customergroup.setCreated(retCustomerGroup.getCreated());
				customergroup.setCreatedBy(retCustomerGroup.getCreatedBy());
			}
			
			retCustomerGroup = em.merge(customergroup);
			retCustomerGroup = em.find(CustomerGroup.class, retCustomerGroup.getCustomerGroup());
		
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CustomerGroupDAOJPAImpl.update():",ex.getMessage());
			throw new DaoException(ex.getMessage(),ex);
			
		}
		return retCustomerGroup;
	}

	
	public List<CustomerGroup> getList(Long customer) throws DaoException {
		List<CustomerGroup> retCustomerGroupList = null;
		try {
		TypedQuery<CustomerGroup> qfindAll = em.createNamedQuery("CustomerGroup.findAll",CustomerGroup.class);
		qfindAll.setParameter("customer", customer);
		retCustomerGroupList =  qfindAll.getResultList();
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CustomerGroupDAOJPAImpl.getCustomerGroup():",ex.getMessage());
			throw new DaoException(ex.getMessage(),ex);
			
		}
		return retCustomerGroupList;
	}


	public boolean remove(Long id) throws DaoException {
		boolean success = true;
		try {
			CustomerGroup customergroup = this.getCustomerGroupByID(id);
			em.remove(customergroup);
			}

			catch(Exception ex)
			{
				success= false;
				cmsLogger.Log("CustomerGroupDAOJPAImpl.remove():",ex.getMessage());
				throw new DaoException(ex.getMessage(),ex);
							
		     }
		return success;
	}
	
}
