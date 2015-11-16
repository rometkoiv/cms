package cms.backend.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import cms.backend.dao.EmpUserDAO;
import cms.backend.model.EmpUser;
import cms.log.cmsLogger;

@Service("EmpUserTransactionalService")
public class EmpUserTransactionalServiceImpl implements EmpUserTransactionalService
{
	@Autowired
	private EmpUserDAO empUserDAO;
	@Autowired
	private Validator validator;
	
	public EmpUser getUserByUserName(String UserName) {
		
		EmpUser empUser = null;
		try {
           empUser = empUserDAO.getUserByUserName(UserName);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("EmpUserTransactionalService.getUserByUserName():",ex.getMessage());
			
		}

		return empUser;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public EmpUser update(EmpUser empUser, Long upuser) {
        try {
           return empUserDAO.update(empUser,upuser);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("EmpUserTransactionalService.update():",ex.getMessage());
			return null;
		}

		
	}

	
	public List<EmpUser> getUsers() {
		List<EmpUser> users = null;
		try {
			
			users = empUserDAO.getUsers();
		}

		catch(Exception ex)
		{
			cmsLogger.Log("EmpUserTransactionalService.getUsers():",ex.getMessage());
			
		}

		return users;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(String username) {
		boolean success = true;
		try {
			
			empUserDAO.remove(username);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("EmpUserTransactionalService.remove("+username+"):",ex.getMessage());
			success = false;
		}
		return success;
	}

	
}
