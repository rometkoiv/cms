package cms.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cms.backend.dao.DistinctSearchDAO;
import cms.backend.model.EmpUser;
import cms.backend.model.Employee;
import cms.backend.model.UserWithName;

@Service("AccountManagerService")
public class AccountManagerService {
	        @Autowired
			private EmpUserTransactionalService empUserService;
			
			@Autowired
			private EmployeeTransactionalService employeeService;
		 
		 private Employee employeeFromBoth(UserWithName userwithname){
			 Employee employee = new Employee();
			 employee.setFirstName(userwithname.getFirstName());
		     employee.setLastName(userwithname.getLastName());
		     employee.setEmployee(userwithname.getEmployee());
			 return employee;
		 }
		 
		 private EmpUser empUserFromBoth(UserWithName userwithname){
			 EmpUser empuser = new EmpUser();
			 empuser.setEmpUser(userwithname.getEmpUser());
		     empuser.setContactEmail(userwithname.getEmail());
		     empuser.setUsername(userwithname.getUsername());
		     empuser.setPassw(userwithname.getPassw());
		     empuser.setEmployeeBean(employeeFromBoth(userwithname));
		     return empuser;
		 }
		 
		 private UserWithName joinBoth(EmpUser empuser, Employee employee){
			 
			 UserWithName userwithname = new UserWithName();
			 if(empuser!=null){
			 userwithname.setEmpUser(empuser.getEmpUser());
			 
			
			 userwithname.setUsername(empuser.getUsername());
			 userwithname.setPassw(empuser.getPassw());
			 userwithname.setEmail(empuser.getContactEmail());
			 }
			 if(employee!=null){
			 userwithname.setEmployee(employee.getEmployee());
			 userwithname.setFirstName(employee.getFirstName());
			 userwithname.setLastName(employee.getLastName());
			 }
		     return userwithname;
		 }
		 
	     public UserWithName SaveAccount(UserWithName userwithname,Long upuser ){
	    	Employee employee = employeeFromBoth(userwithname);
	    	EmpUser empuser =  empUserFromBoth(userwithname);
	    	employee = employeeService.update(employee,upuser);
	    	empuser.setEmployeeBean(employee);
	    	empuser = empUserService.update(empuser,upuser);
	    	return joinBoth(empuser,employee);
	     }
	     
	     public UserWithName viewAccount(String username){
	    	 EmpUser empuser =  empUserService.getUserByUserName(username);
	    	 if(empuser!=null){
	    	 Employee employee = empuser.getEmployeeBean();
	    	 return joinBoth(empuser,employee);
	    	 }
	    	 else return null;
	     }
	     
	     public List<UserWithName> getAccountList(){
	    	 List<EmpUser> eList = null;
	    	 List<UserWithName> retList = new ArrayList<UserWithName>();
	    	 eList =  empUserService.getUsers();
	    	 for(EmpUser e : eList){
	    		 retList.add(joinBoth(e,e.getEmployeeBean()));
	    	 }
	    	 
	    	 
	    	 return retList;
	     }
	     
	     public boolean remove(String username){
	    	 EmpUser empuser =  empUserService.getUserByUserName(username);
	    	 Employee employee = empuser.getEmployeeBean();
	    	 DistinctSearchDAO dsc = new DistinctSearchDAO();
	    	 System.out.println(employee.getEmployee());
	    	 Long inUse = dsc.employeeInUse(employee.getEmployee());
	    	 if(inUse == 0){
	    		 return empUserService.remove(username);
	    	 }else{
	    		 return false;
	    	 }
	    	 
	    	 //return empUserService.remove(username);
	     }
}
