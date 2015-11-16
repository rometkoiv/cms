package cms.backend.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import cms.backend.model.CGroup;
import cms.log.cmsLogger;


@Repository
public class CGroupDAOJPAImpl implements CGroupDAO{
	@PersistenceContext
	private EntityManager em;

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	public CGroup getCGroupByID(Long id) throws DaoException {
		
		CGroup retCGroup = null;
		try {
		TypedQuery<CGroup> qGetOne = em.createNamedQuery("CGroup.findByID",CGroup.class);
		qGetOne.setParameter("id", id);
		retCGroup =  qGetOne.getSingleResult();
		}
        
		catch(Exception ex)
		{
			cmsLogger.Log("CGroupDAOJPAImpl.getCGroupByID():",ex.getMessage());
			throw new DaoException(ex.getMessage(),ex);
			
		}
		return retCGroup;

	}


	
	public CGroup update(CGroup cgroup, Long upuser) throws DaoException {
		CGroup retCGroup = null;
		try {
			if(cgroup.getCGroup() == 0){
				cgroup.setCreated(DAOUtils.getTimeStamp());
				cgroup.setCreatedBy(upuser);
			}
			else{
				retCGroup = em.find(CGroup.class, cgroup.getCGroup());
				cgroup.setCreated(retCGroup.getCreated());
				cgroup.setCreatedBy(retCGroup.getCreatedBy());
			}
			cgroup.setUpdatedBy(upuser);
			cgroup.setUpdated(DAOUtils.getTimeStamp());
			
			retCGroup = em.merge(cgroup);
			retCGroup = em.find(CGroup.class, retCGroup.getCGroup());
		
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CGroupDAOJPAImpl.update():",ex.getMessage());
			throw new DaoException(ex.getMessage(),ex);
			
		}
		return retCGroup;
	}

	
	public List<CGroup> getList() throws DaoException {
		List<CGroup> retCGroupList = null;
		try {
		TypedQuery<CGroup> qfindAll = em.createNamedQuery("CGroup.findAll",CGroup.class);
		retCGroupList =  qfindAll.getResultList();
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CGroupDAOJPAImpl.getCGroup():",ex.getMessage());
			throw new DaoException(ex.getMessage(),ex);
			
		}
		return retCGroupList;
	}
	
	public List<CGroup> findInUse(Long id) throws DaoException {
		List<CGroup> retCGroupList = null;
		try {
		TypedQuery<CGroup> qfindAll = em.createNamedQuery("CGroup.findInUse",CGroup.class);
		qfindAll.setParameter("id", id);
		retCGroupList =  qfindAll.getResultList();
		}

		catch(Exception ex)
		{
			cmsLogger.Log("CGroupDAOJPAImpl.getCGroup():",ex.getMessage());
			throw new DaoException(ex.getMessage(),ex);
			
		}
		return retCGroupList;
	}



	public boolean remove(Long id) throws DaoException {
		boolean success = true;
		try {
			CGroup cgroup = this.getCGroupByID(id);
			em.remove(cgroup);
			}

			catch(Exception ex)
			{
				success= false;
				cmsLogger.Log("CGroupDAOJPAImpl.remove():",ex.getMessage());
				throw new DaoException(ex.getMessage(),ex);
							
		     }
		return success;
	}
	
}
