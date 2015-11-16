package cms.backend.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import cms.backend.model.EmpUser;
import cms.log.cmsLogger;


@Repository
public class EmpUserDAOJPAImpl implements EmpUserDAO{
	@PersistenceContext
	private EntityManager em;

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	
	public EmpUser getUserByUserName(String UserName) throws DaoException {
		
		EmpUser retEmpUser = null;
		try {
		TypedQuery<EmpUser> qGetUserByUserName = em.createNamedQuery("EmpUser.getUserByUserName",EmpUser.class);
		qGetUserByUserName.setParameter("username", UserName);
		
		retEmpUser =  qGetUserByUserName.getSingleResult();
		}

		catch(Exception ex)
		{
			cmsLogger.Log("EmpUserDAOJPAImpl.getUserByUserName():",ex.getMessage());
			throw new DaoException(ex.getMessage(),ex);
			
		}
		return retEmpUser;

	}


	
	public EmpUser update(EmpUser empUser, Long upuser) throws DaoException {
		EmpUser retEmpUser = null;
		try {
			if(empUser.getEmpUser() == 0){
				empUser.setCreated(DAOUtils.getTimeStamp());
				empUser.setCreatedBy(upuser);
			}
			else{
				retEmpUser = em.find(EmpUser.class, empUser.getEmpUser());
				empUser.setCreated(retEmpUser.getCreated());
				empUser.setCreatedBy(retEmpUser.getCreatedBy());
			}
			empUser.setUpdatedBy(upuser);
			empUser.setUpdated(DAOUtils.getTimeStamp());
			
			retEmpUser = em.merge(empUser);
			retEmpUser = em.find(EmpUser.class, retEmpUser.getEmpUser());
			
		/*em.merge(empUser);
		TypedQuery<EmpUser> qGetUserByUserName = em.createNamedQuery("EmpUser.getUserByempUser",EmpUser.class);
		qGetUserByUserName.setParameter("empUser", empUser.getEmpUser());
		retEmpUser =  qGetUserByUserName.getSingleResult();*/
		}

		catch(Exception ex)
		{
			cmsLogger.Log("EmpUserDAOJPAImpl.update():",ex.getMessage());
			throw new DaoException(ex.getMessage(),ex);
			
		}
		return retEmpUser;
	}



	public List<EmpUser> getUsers() throws DaoException {
		List<EmpUser> retEmpUserList = null;
		try {
		TypedQuery<EmpUser> qfindAll = em.createNamedQuery("EmpUser.findAll",EmpUser.class);
		retEmpUserList =  qfindAll.getResultList();
		}

		catch(Exception ex)
		{
			cmsLogger.Log("EmpUserDAOJPAImpl.getUsers():",ex.getMessage());
			throw new DaoException(ex.getMessage(),ex);
			
		}
		return retEmpUserList;
	}


	
	public boolean remove(String username) throws DaoException{
		boolean success = true;
		try {
			EmpUser empUser = this.getUserByUserName(username);
			em.remove(empUser);
			}

			catch(Exception ex)
			{
				success= false;
				cmsLogger.Log("EmpUserDAOJPAImpl.remove():",ex.getMessage());
				throw new DaoException(ex.getMessage(),ex);
							
		     }
		return success;
	}
	

	
}
