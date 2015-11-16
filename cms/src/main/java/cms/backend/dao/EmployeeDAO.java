package cms.backend.dao;

import java.util.List;

import cms.backend.model.Employee;


public interface EmployeeDAO {
	public Employee getEployeeByID(Long id) throws DaoException;
	public Employee update(Employee employee, Long upuser) throws DaoException;
	public List<Employee> getEployees() throws DaoException ;
	
}
