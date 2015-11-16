package cms.backend.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import cms.backend.model.Employee;
import cms.log.cmsLogger;


@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO{
	@PersistenceContext
	private EntityManager em;

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	
	public Employee getEployeeByID(Long id) throws DaoException {
		
		Employee retEmployee = null;
		try {
		TypedQuery<Employee> qGetOne = em.createNamedQuery("Employee.findByID",Employee.class);
		qGetOne.setParameter("id", id);
		
		retEmployee =  qGetOne.getSingleResult();
		}

		catch(Exception ex)
		{
			cmsLogger.Log("EmployeeDAOJPAImpl.getEmployeeByID():",ex.getMessage());
			throw new DaoException(ex.getMessage(),ex);
			
		}
		return retEmployee;

	}


	
	public Employee update(Employee employee,Long upuser) throws DaoException {
		Employee retEmployee = null;
		try {
			if(employee.getEmployee() == 0){
				employee.setCreated(DAOUtils.getTimeStamp());
				employee.setCreatedBy(upuser);
			}
			else{
				retEmployee = em.find(Employee.class, employee.getEmployee());
				employee.setCreated(retEmployee.getCreated());
				employee.setCreatedBy(retEmployee.getCreatedBy());
			}
			employee.setUpdatedBy(upuser);
			employee.setUpdated(DAOUtils.getTimeStamp());
			
			retEmployee = em.merge(employee);
			retEmployee = em.find(Employee.class, retEmployee.getEmployee());
			
			
		/*TypedQuery<Employee> qGetOne;
		if(employee.getEmployee()==0 && employee.getFirstName() !=null && employee.getLastName()!=null){
			qGetOne = em.createNamedQuery("Employee.findByNames",Employee.class);
			qGetOne.setParameter("firstName", employee.getFirstName());
			qGetOne.setParameter("lastName", employee.getLastName());
			retEmployee =  qGetOne.getSingleResult();
		}
		else{
			qGetOne = em.createNamedQuery("Employee.findByID",Employee.class);
			qGetOne.setParameter("id", employee.getEmployee());
			retEmployee =  qGetOne.getSingleResult();
		}*/
		
		
		}

		catch(Exception ex)
		{
			cmsLogger.Log("EmployeeDAOJPAImpl.update():",ex.getMessage());
			throw new DaoException(ex.getMessage(),ex);
			
		}
		return retEmployee;
	}



	public List<Employee> getEployees() throws DaoException {
		List<Employee> retEmployeeList = null;
		try {
		TypedQuery<Employee> qfindAll = em.createNamedQuery("Employee.findAll",Employee.class);
		retEmployeeList =  qfindAll.getResultList();
		}

		catch(Exception ex)
		{
			cmsLogger.Log("EmployeeDAOJPAImpl.getEmployees():",ex.getMessage());
			throw new DaoException(ex.getMessage(),ex);
			
		}
		return retEmployeeList;
	}


	
}
