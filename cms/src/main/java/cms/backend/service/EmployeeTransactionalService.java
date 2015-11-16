package cms.backend.service;

import java.util.List;

import cms.backend.model.Employee;

public interface EmployeeTransactionalService {
	public Employee getEmployeeByID(Long id);
	public Employee update(Employee employee,Long upuser);
	public List<Employee> getEmployees();
	
}
