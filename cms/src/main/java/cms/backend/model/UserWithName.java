package cms.backend.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class UserWithName {
    private long empUser;
    private long employee;
    @NotEmpty
	@Size(max = 10, message="Maksimum 10 märki")
    private String username;
    @NotEmpty(message="Parool peab olema")
    private String passw;
    @NotEmpty(message="Nimi peab olema")
    private String firstName;
    @NotEmpty(message="Perenimi peab olema")
    private String lastName;
    @Email(message ="See peab olema epost")
    private String email;
	public long getEmpUser() {
		return empUser;
	}
	public void setEmpUser(long empUser) {
		this.empUser = empUser;
	}
	public long getEmployee() {
		return employee;
	}
	public void setEmployee(long employee) {
		this.employee = employee;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassw() {
		return passw;
	}
	public void setPassw(String passw) {
		this.passw = passw;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
