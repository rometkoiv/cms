package cms.backend.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c"),
@NamedQuery(name="Customer.findByID", query="SELECT c FROM Customer c where c.customer=:id")
})
@JsonIdentityInfo(generator = ObjectIdGenerators.None.class ,property = "@id")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty("customer")
	private long customer;
	
	@Past(message="Tulevik pole lubatud")
    @Column(name="birth_date")
	@JsonProperty(value="birthDate",required=false)
	private Timestamp birthDate;
	
	@JsonIgnore
	private Timestamp created;
    
	@JsonIgnore
	@Column(name="created_by")
	private Long createdBy;
    
	@JsonIgnore
	@Column(name="cst_state_type")
	private BigDecimal cstStateType;
    
	@JsonIgnore
	@Column(name="cst_type")
	private BigDecimal cstType;
	
	@JsonProperty("firstName")
	@NotEmpty(message="Ei tohi olla tühi")
	@Column(name="first_name")
	private String firstName;
    
	@Size(max = 11, message="Maksimum 11 märki")
	@Pattern(regexp="^$|[0-9]{11}", message="Kui soovid sisestada, siis 11 kohta ja numbrid")
	@JsonProperty("identityCode")
	@Column(name="identity_code")
	private String identityCode;
	
	@JsonProperty("lastName")
	@NotEmpty(message="Ei tohi olla tühi")
	@Column(name="last_name")
	private String lastName;
    
	@JsonProperty("note")
	private String note;
    
	@JsonIgnore
	private Timestamp updated;

	@Column(name="updated_by")
	
	private Long updatedBy;

	//bi-directional many-to-one association to CustomerGroup
	@OneToMany(mappedBy="customerBean", fetch=FetchType.EAGER,cascade = CascadeType.DETACH)
	//@JsonManagedReference
	@JsonIgnore
	private List<CustomerGroup> customerGroups;

	//bi-directional many-to-one association to CstAddress
	@OneToMany(mappedBy="customerBean", fetch=FetchType.EAGER,cascade = CascadeType.DETACH)
	@JsonIgnore
	@JsonManagedReference
	private List<CstAddress> cstAddresses;

	//bi-directional many-to-one association to CommDevice
	@OneToMany(mappedBy="customerBean",fetch=FetchType.EAGER,cascade = CascadeType.DETACH)
	@JsonIgnore
	private List<CommDevice> commDevices;

	public Customer() {
	}

	public long getCustomer() {
		return this.customer;
	}

	public void setCustomer(long customer) {
		this.customer = customer;
	}

	public Timestamp getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
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

	public BigDecimal getCstStateType() {
		return this.cstStateType;
	}

	public void setCstStateType(BigDecimal cstStateType) {
		this.cstStateType = cstStateType;
	}

	public BigDecimal getCstType() {
		return this.cstType;
	}

	public void setCstType(BigDecimal cstType) {
		this.cstType = cstType;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getIdentityCode() {
		return this.identityCode;
	}

	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
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

	public List<CustomerGroup> getCustomerGroups() {
		return this.customerGroups;
	}

	public void setCustomerGroups(List<CustomerGroup> customerGroups) {
		this.customerGroups = customerGroups;
	}

	public CustomerGroup addCustomerGroup(CustomerGroup customerGroup) {
		getCustomerGroups().add(customerGroup);
		customerGroup.setCustomerBean(this);

		return customerGroup;
	}

	public CustomerGroup removeCustomerGroup(CustomerGroup customerGroup) {
		getCustomerGroups().remove(customerGroup);
		customerGroup.setCustomerBean(null);

		return customerGroup;
	}

	public List<CstAddress> getCstAddresses() {
		return this.cstAddresses;
	}

	public void setCstAddresses(List<CstAddress> cstAddresses) {
		this.cstAddresses = cstAddresses;
	}

	public CstAddress addCstAddress(CstAddress cstAddress) {
		getCstAddresses().add(cstAddress);
		cstAddress.setCustomerBean(this);

		return cstAddress;
	}

	public CstAddress removeCstAddress(CstAddress cstAddress) {
		getCstAddresses().remove(cstAddress);
		cstAddress.setCustomerBean(null);

		return cstAddress;
	}

	public List<CommDevice> getCommDevices() {
		return this.commDevices;
	}

	public void setCommDevices(List<CommDevice> commDevices) {
		this.commDevices = commDevices;
	}

	public CommDevice addCommDevice(CommDevice commDevice) {
		getCommDevices().add(commDevice);
		commDevice.setCustomerBean(this);

		return commDevice;
	}

	public CommDevice removeCommDevice(CommDevice commDevice) {
		getCommDevices().remove(commDevice);
		commDevice.setCustomerBean(null);

		return commDevice;
	}

}