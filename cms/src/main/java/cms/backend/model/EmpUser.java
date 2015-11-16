package cms.backend.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the emp_user database table.
 * 
 */
@Entity
@Table(name="emp_user")
@NamedQueries({
@NamedQuery(name="EmpUser.findAll", query="SELECT e FROM EmpUser e"),
@NamedQuery(name="EmpUser.getUserByUserName", query="SELECT e FROM EmpUser e where e.username = :username"),
@NamedQuery(name="EmpUser.getUserByempUser", query="SELECT e FROM EmpUser e where e.empUser = :empUser")
})
public class EmpUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emp_user")
	private long empUser;
	@Email(message ="See peab olema epost")
	@Column(name="contact_email")
	private String contactEmail;

	private Timestamp created;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="last_session")
	private BigDecimal lastSession;
	@NotEmpty(message="Parool peab olema")
	private String passw;
	
	
	private Timestamp updated;

	@Column(name="updated_by")
	private Long updatedBy;

	@Column(name="user_status_type")
	private BigDecimal userStatusType;
	@NotEmpty
	@Size(max = 10, message="Maksimum 10 märki")
	private String username;

	
	@OneToOne(orphanRemoval=true)
	@JoinColumn(name="employee")
	private Employee employeeBean;

	public EmpUser() {
	}

	public long getEmpUser() {
		return this.empUser;
	}

	public void setEmpUser(long empUser) {
		this.empUser = empUser;
	}

	public String getContactEmail() {
		return this.contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
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

	public BigDecimal getLastSession() {
		return this.lastSession;
	}

	public void setLastSession(BigDecimal lastSession) {
		this.lastSession = lastSession;
	}

	public String getPassw() {
		return this.passw;
	}

	public void setPassw(String passw) {
		this.passw = passw;
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

	public BigDecimal getUserStatusType() {
		return this.userStatusType;
	}

	public void setUserStatusType(BigDecimal userStatusType) {
		this.userStatusType = userStatusType;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Employee getEmployeeBean() {
		return this.employeeBean;
	}

	public void setEmployeeBean(Employee employeeBean) {
		this.employeeBean = employeeBean;
	}

}