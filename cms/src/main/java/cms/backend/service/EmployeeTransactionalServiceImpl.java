package cms.backend.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import cms.backend.dao.EmployeeDAO;
import cms.backend.model.Employee;
import cms.log.cmsLogger;

@Service("EmployeeTransactionalService")
public class EmployeeTransactionalServiceImpl implements EmployeeTransactionalService
{
	@Autowired
	private EmployeeDAO employeeDAO;
	@Autowired
	private Validator validator;
	
	public Employee getEmployeeByID(Long id) {
		
		Employee employee = null;
		try {
			employee = employeeDAO.getEployeeByID(id);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("EmployeeTransactionalServiceImpl.getEployeeByID():",ex.getMessage());
			
		}

		return employee;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Employee update(Employee employee,Long upuser) {
        try {
           return employeeDAO.update(employee,upuser);
		}

		catch(Exception ex)
		{
			cmsLogger.Log("EmployeeTransactionalServiceImpl.update():",ex.getMessage());
			return null;
		}

		
	}

	
	public List<Employee> getEmployees() {
		List<Employee> employees = null;
		try {

			employees = employeeDAO.getEployees();
		}

		catch(Exception ex)
		{
			cmsLogger.Log("EmployeeTransactionalServiceImpl.getProductsByCatalog():",ex.getMessage());
			
		}

		return employees;
	}

	
}
