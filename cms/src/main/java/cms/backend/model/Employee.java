package cms.backend.model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e"),
@NamedQuery(name="Employee.findByID", query="SELECT e FROM Employee e where e.employee = :id"),
@NamedQuery(name="Employee.findByNames", query="SELECT e FROM Employee e where e.firstName = :firstName and e.lastName = :lastName")
})
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long employee;

	private Timestamp created;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="current_manager")
	private BigDecimal currentManager;

	@Column(name="current_position")
	private BigDecimal currentPosition;

	@Column(name="current_struct_unit")
	private BigDecimal currentStructUnit;

	@Column(name="emp_code")
	private String empCode;

	@Column(name="emp_role")
	private BigDecimal empRole;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;
	
	private Timestamp updated;

	@Column(name="updated_by")
	private Long updatedBy;

	//bi-directional many-to-one association to EmpUser
	@OneToOne(mappedBy="employeeBean")
	private EmpUser empUser;

	public Employee() {
	}

	public long getEmployee() {
		return this.employee;
	}

	public void setEmployee(long employee) {
		this.employee = employee;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public BigDecimal getCurrentManager() {
		return this.currentManager;
	}

	public void setCurrentManager(BigDecimal currentManager) {
		this.currentManager = currentManager;
	}

	public BigDecimal getCurrentPosition() {
		return this.currentPosition;
	}

	public void setCurrentPosition(BigDecimal currentPosition) {
		this.currentPosition = currentPosition;
	}

	public BigDecimal getCurrentStructUnit() {
		return this.currentStructUnit;
	}

	public void setCurrentStructUnit(BigDecimal currentStructUnit) {
		this.currentStructUnit = currentStructUnit;
	}

	public String getEmpCode() {
		return this.empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public BigDecimal getEmpRole() {
		return this.empRole;
	}

	public void setEmpRole(BigDecimal empRole) {
		this.empRole = empRole;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Timestamp getUpdated() {
		return this.updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public void setEmpUserBean(EmpUser empUser) {
		this.empUser = empUser;
	}

	public EmpUser getEmpUserBean() {
		return this.empUser;
	}

	


}