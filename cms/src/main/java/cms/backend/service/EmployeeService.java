package cms.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cms.backend.model.Employee;
import cms.log.cmsLogger;

@Service("EmployeeService")
public class EmployeeService {
	
	@Autowired
	private EmployeeTransactionalService employeeTransactionalService ;
	
	public Employee getEmployeeByID(Long id){
		Employee employee = null;
		try {
			employee=employeeTransactionalService.getEmployeeByID(id);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("EmployeeService.getEmployeeByID():",ex.getMessage());
		}

		return employee;
	}
	public Employee update(Employee employee, Long upuser){
		try {
			employee=employeeTransactionalService.update(employee,upuser);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("EmployeeService.update():",ex.getMessage());
		}

		return employee;
	}
	public List<Employee> getEmployees(){
		List<Employee> employeeList = null;
		try {
			employeeList=employeeTransactionalService.getEmployees();
		}

		catch(Exception ex)
		{
			cmsLogger.Log("EmployeeService.getEmployees():",ex.getMessage());
		}
		return employeeList;
	}
	
}
