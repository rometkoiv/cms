package cms.backend.dao;

import java.util.List;

import cms.backend.model.EmpUser;


public interface EmpUserDAO {
	public EmpUser getUserByUserName(String UserName) throws DaoException;
	public EmpUser update(EmpUser empUser, Long upuser) throws DaoException;
	public List<EmpUser> getUsers() throws DaoException ;
	boolean remove (String UserName) throws DaoException ;
	
}
