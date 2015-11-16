package cms.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cms.backend.model.EmpUser;
import cms.log.cmsLogger;

@Service("EmpUserService")
public class EmpUserService {
	
	@Autowired
	private EmpUserTransactionalService empUserTransactionalService ;
	
	public EmpUser getUserByUserName(String UserName){
		EmpUser empUser = null;
		try {
			empUser=empUserTransactionalService.getUserByUserName(UserName);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("EmpUserTransactionalService.getUserByUserName():",ex.getMessage());
		}

		return empUser;
	}
	public EmpUser update(EmpUser empUser, Long upuser){
		try {
			empUser=empUserTransactionalService.update(empUser,upuser);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("EmpUserTransactionalService.update():",ex.getMessage());
		}

		return empUser;
	}
	public List<EmpUser> getUsers(){
		List<EmpUser> empUserList = null;
		try {
			empUserList=empUserTransactionalService.getUsers();
		}

		catch(Exception ex)
		{
			cmsLogger.Log("EmpUserTransactionalService.getUsers():",ex.getMessage());
		}
		return empUserList;
	}
	
	public boolean remove(String username){
		boolean success = true;
		try {
			success = empUserTransactionalService.remove(username);
		}

		catch(Exception ex)
		{
			success=false;
			cmsLogger.Log("EmpUserTransactionalService.remove():",ex.getMessage());
		}

		return success;
	}
	
}
