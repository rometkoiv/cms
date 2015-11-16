package cms.backend.service;

import java.util.List;

import cms.backend.model.EmpUser;

public interface EmpUserTransactionalService {
	public EmpUser getUserByUserName(String UserName);
	public EmpUser update(EmpUser empUser, Long upuser);
	public List<EmpUser> getUsers();
	public boolean remove(String empUser);
	
}
