package cms.backend.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import cms.backend.model.CstAddress;
import cms.log.cmsLogger;

@Repository
public class CstAddressDAOJPAImpl implements CstAddressDAO {
	@PersistenceContext
	private EntityManager em;

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
    //** Esimene on adresss teine customeri main
	public CstAddress getCstAddressByID(Long id, Long customer)
			throws DaoException {

		CstAddress retCstAddress = null;
		try {
			if (id != null && customer != null) {
				TypedQuery<CstAddress> qGetOne = em.createNamedQuery(
						"CstAddress.findByIDForCustomer", CstAddress.class);
				qGetOne.setParameter("id", id);
				qGetOne.setParameter("customer", customer);
				retCstAddress = qGetOne.getSingleResult();
			}

			if (customer != null && id == null) {
				TypedQuery<CstAddress> qGetOne = em.createNamedQuery(
						"CstAddress.findCustomerMain", CstAddress.class);
				qGetOne.setParameter("customer", customer);
				
				List<CstAddress> retList = qGetOne.getResultList();
				if(retList!= null && !retList.isEmpty())
				{
					retCstAddress =  retList.get(0);
				}
				
			}
			if (customer == null && id != null) {
				TypedQuery<CstAddress> qGetOne = em.createNamedQuery(
						"CstAddress.findByID", CstAddress.class);
				qGetOne.setParameter("id", id);
				retCstAddress = qGetOne.getSingleResult();
			}
		}

		catch (Exception ex) {
			cmsLogger.Log("CstAddressDAOJPAImpl.getCstAddressByID():",
					ex.getMessage());
			throw new DaoException(ex.getMessage(), ex);

		}
		return retCstAddress;

	}
    

	
	public CstAddress update(CstAddress cstaddress, Long upuser) throws DaoException {
		CstAddress retCstAddress = null;
		
		try {
			if (cstaddress.getCstAddress() == 0) {
				cstaddress.setCreated(DAOUtils.getTimeStamp());
				cstaddress.setCreatedBy(upuser);
			} else {
				retCstAddress = em.find(CstAddress.class,
						cstaddress.getCstAddress());
				cstaddress.setCreated(retCstAddress.getCreated());
				cstaddress.setCreatedBy(retCstAddress.getCreatedBy());
			}
			
			cstaddress.setUpdatedBy(upuser);
			cstaddress.setUpdated(DAOUtils.getTimeStamp());

			retCstAddress = em.merge(cstaddress);
			//if(retCstAddress== null){System.out.println("Null pärast em.merge");}
			retCstAddress = em.find(CstAddress.class,retCstAddress.getCstAddress());
			//if(retCstAddress== null){System.out.println("Null pärast em.find");}
		}

		catch (Exception ex) {
			cmsLogger.Log("CstAddressDAOJPAImpl.update():", ex.getMessage());
			throw new DaoException(ex.getMessage(), ex);
		}
		return retCstAddress;
	}

	public List<CstAddress> getList(Long customer) throws DaoException {
		List<CstAddress> retCstAddressList = null;
		try {
			if (customer == null) {
				TypedQuery<CstAddress> qfindAll = em.createNamedQuery(
						"CstAddress.findAll", CstAddress.class);
				retCstAddressList = qfindAll.getResultList();
			} else {
				TypedQuery<CstAddress> qfindAll = em.createNamedQuery(
						"CstAddress.findByCustomer", CstAddress.class);
				qfindAll.setParameter("customer", customer);
				retCstAddressList = qfindAll.getResultList();
			}
		}

		catch (Exception ex) {
			cmsLogger.Log("CstAddressDAOJPAImpl.getCstAddress():",
					ex.getMessage());
			throw new DaoException(ex.getMessage(), ex);

		}
		return retCstAddressList;
	}

	public boolean remove(Long id) throws DaoException {
		boolean success = true;
		try {
			CstAddress cstaddress = this.getCstAddressByID(id,null);
			em.remove(cstaddress);
		}

		catch (Exception ex) {
			success = false;
			cmsLogger.Log("CstAddressDAOJPAImpl.remove():", ex.getMessage());
			throw new DaoException(ex.getMessage(), ex);

		}
		return success;
	}

}
