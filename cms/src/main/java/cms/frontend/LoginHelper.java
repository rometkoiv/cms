package cms.frontend;

import java.util.List;

import cms.backend.dao.DaoException;
import cms.backend.dao.EmpUserDAOJPAImpl;
import cms.backend.model.EmpUser;



public class LoginHelper {

	private EmpUserDAOJPAImpl empUserDAO = new EmpUserDAOJPAImpl();
	public List<EmpUser> AvailableUsers(){
		
		List<EmpUser> returnList = null;
		
		try {
			if(empUserDAO!=null){
			returnList = empUserDAO.getUsers();
			System.out.print("BS"+returnList.size());
			}else{System.out.print("BS");}
			
		} catch (DaoException e) {
			System.out.print("BS1"+e.getMessage());
		}
		return returnList;
	}
}
