package cms.backend.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import cms.backend.model.CommDeviceType;
import cms.log.cmsLogger;


@Repository
public class CommDeviceTypeDAOJPAImpl implements CommDeviceTypeDAO{
	@PersistenceContext
	private EntityManager em;

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	public CommDeviceType getCommDeviceTypeByID(Long id) throws DaoException {
		
		CommDeviceType retCommDeviceType = null;
		try {
		TypedQuery<CommDeviceType> qGetOne = em.createNamedQuery("CommDeviceType.findByID",CommDeviceType.class);
		qGetOne.setParameter("id", id);
		retCommDeviceType =  qGetOne.getSingleResult();
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CommDeviceTypeDAOJPAImpl.getCommDeviceTypeByID():",ex.getMessage());
			throw new DaoException(ex.getMessage(),ex);
			
		}
		return retCommDeviceType;

	}
	

	
	public CommDeviceType update(CommDeviceType commdevicetype, Long upuser) throws DaoException {
		CommDeviceType retCommDeviceType = null;
		try {
			retCommDeviceType = em.merge(commdevicetype);
			retCommDeviceType = em.find(CommDeviceType.class, retCommDeviceType.getCommDeviceType());
		
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CommDeviceTypeDAOJPAImpl.update():",ex.getMessage());
			throw new DaoException(ex.getMessage(),ex);
			
		}
		return retCommDeviceType;
	}
    
	public List<CommDeviceType> findInUse(Long id) throws DaoException {
		List<CommDeviceType> retCommDeviceTypeList = null;
		try {
		TypedQuery<CommDeviceType> qfindAll = em.createNamedQuery("CommDeviceType.findInUse",CommDeviceType.class);
		qfindAll.setParameter("id", id);
		retCommDeviceTypeList =  qfindAll.getResultList();
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CommDeviceTypeDAOJPAImpl.findInUse():",ex.getMessage());
			throw new DaoException(ex.getMessage(),ex);
			
		}
		return retCommDeviceTypeList;
	}
	
	public List<CommDeviceType> getList() throws DaoException {
		List<CommDeviceType> retCommDeviceTypeList = null;
		try {
		TypedQuery<CommDeviceType> qfindAll = em.createNamedQuery("CommDeviceType.findAll",CommDeviceType.class);
		retCommDeviceTypeList =  qfindAll.getResultList();
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CommDeviceTypeDAOJPAImpl.getCommDeviceType():",ex.getMessage());
			throw new DaoException(ex.getMessage(),ex);
			
		}
		return retCommDeviceTypeList;
	}


	public boolean remove(Long id) throws DaoException {
		boolean success = true;
		try {
			CommDeviceType commdevicetype = this.getCommDeviceTypeByID(id);
			em.remove(commdevicetype);
			}

			catch(Exception ex)
			{
				success= false;
				cmsLogger.Log("CommDeviceTypeDAOJPAImpl.remove():",ex.getMessage());
				throw new DaoException(ex.getMessage(),ex);
							
		     }
		return success;
	}
	
}
