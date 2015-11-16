package cms.backend.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import cms.backend.model.CommDevice;
import cms.log.cmsLogger;

@Repository
public class CommDeviceDAOJPAImpl implements CommDeviceDAO {
	@PersistenceContext
	private EntityManager em;

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
    
	public CommDevice getCommDeviceByID(Long id)
			throws DaoException {

		CommDevice retCommDevice = null;
		try {
			if (id != null) {
				TypedQuery<CommDevice> qGetOne = em.createNamedQuery(
						"CommDevice.findByID", CommDevice.class);
				qGetOne.setParameter("id", id);
				retCommDevice = qGetOne.getSingleResult();
			}
		}

		catch (Exception ex) {
			cmsLogger.Log("CommDeviceDAOJPAImpl.getCommDeviceByID():",
					ex.getMessage());
			throw new DaoException(ex.getMessage(), ex);

		}
		return retCommDevice;

	}
    

	
	public CommDevice update(CommDevice commdevice) throws DaoException {
		CommDevice retCommDevice = null;
		
		try {
			if (commdevice.getCommDevice() == 0) {
				commdevice.setCreated(DAOUtils.getTimeStamp());
				
			} else {
				retCommDevice = em.find(CommDevice.class,
				commdevice.getCommDevice());
				commdevice.setCreated(retCommDevice.getCreated());
			}
			
			retCommDevice = em.merge(commdevice);
			retCommDevice = em.find(CommDevice.class,retCommDevice.getCommDevice());
			
		}

		catch (Exception ex) {
			cmsLogger.Log("CommDeviceDAOJPAImpl.update():", ex.getMessage());
			throw new DaoException(ex.getMessage(), ex);
		}
		return retCommDevice;
	}

	public List<CommDevice> getList(Long customer) throws DaoException {
		List<CommDevice> retCommDeviceList = null;
		try {
			if (customer == null) {
				TypedQuery<CommDevice> qfindAll = em.createNamedQuery(
						"CommDevice.findAll", CommDevice.class);
				retCommDeviceList = qfindAll.getResultList();
			} else {
				TypedQuery<CommDevice> qfindAll = em.createNamedQuery(
						"CommDevice.findByCustomer", CommDevice.class);
				qfindAll.setParameter("customer", customer);
				retCommDeviceList = qfindAll.getResultList();
			}
		}

		catch (Exception ex) {
			cmsLogger.Log("CommDeviceDAOJPAImpl.getCommDevice():",
					ex.getMessage());
			throw new DaoException(ex.getMessage(), ex);

		}
		return retCommDeviceList;
	}

	public boolean remove(Long id) throws DaoException {
		boolean success = true;
		try {
			CommDevice commdevice = this.getCommDeviceByID(id);
			em.remove(commdevice);
			//System.out.println("kustutan");
		}

		catch (Exception ex) {
			success = false;
			cmsLogger.Log("CommDeviceDAOJPAImpl.remove():", ex.getMessage());
			throw new DaoException(ex.getMessage(), ex);

		}
		return success;
	}

}
