package cms.backend.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the cst_address database table.
 * 
 */
@Entity
@Table(name="cst_address")
@NamedQueries({
@NamedQuery(name="CstAddress.findAll", query="SELECT c FROM CstAddress c"),
@NamedQuery(name="CstAddress.findByID", query="SELECT c FROM CstAddress c where c.cstAddress=:id"),
@NamedQuery(name="CstAddress.findByIDForCustomer", query="SELECT c FROM CstAddress c where c.cstAddress=:id and c.customerBean.customer=:customer"),
@NamedQuery(name="CstAddress.findByCustomer", query="SELECT c FROM CstAddress c where c.customerBean.customer=:customer order by c.addressType"),
@NamedQuery(name="CstAddress.findCustomerMain", query="SELECT c FROM CstAddress c where c.customerBean.customer=:customer and c.addressType=1")
})
@JsonIdentityInfo(generator = ObjectIdGenerators.None.class ,property = "@id")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CstAddress implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cst_address")
	private long cstAddress;
	
	@NotEmpty(message="Ei tohi olla tühi")
	private String address;
    
	@JsonProperty("addressType")
	@Column(name="address_type")
	private Long addressType;

	private BigDecimal country;
	
	@NotEmpty(message="Ei tohi olla tühi")
	private String county;

	private Timestamp created;

	@Column(name="created_by")
	private Long createdBy;
	
	
	private String email;
    
	private String house;

	private String mobile;

	private String note;

	private String parish;

	private String phone;

	private String sms;
	
	@NotEmpty(message="Ei tohi olla tühi")
	@Column(name="town_county")
	private String townCounty;

	private Timestamp updated;

	@Column(name="updated_by")
	private Long updatedBy;
	
	@NotEmpty(message="Ei tohi olla tühi")
	@Size(max = 5, message="Maksimum 5 märki")
	private String zip;

	//bi-directional many-to-one association to Customer Töötab  CascadeType.DETACH
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.DETACH)
	@JsonBackReference 
	@JoinColumn(name="customer")
	private Customer customerBean;
    
	
	
	public CstAddress() {
	}

	public long getCstAddress() {
		return this.cstAddress;
	}

	public void setCstAddress(long cstAddress) {
		this.cstAddress = cstAddress;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getAddressType() {
		return this.addressType;
	}

	public void setAddressType(Long addressType) {
		this.addressType = addressType;
	}

	public BigDecimal getCountry() {
		return this.country;
	}

	public void setCountry(BigDecimal country) {
		this.country = country;
	}

	public String getCounty() {
		return this.county;
	}

	public void setCounty(String county) {
		this.county = county;
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHouse() {
		return this.house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getParish() {
		return this.parish;
	}

	public void setParish(String parish) {
		this.parish = parish;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSms() {
		return this.sms;
	}

	public void setSms(String sms) {
		this.sms = sms;
	}

	public String getTownCounty() {
		return this.townCounty;
	}

	public void setTownCounty(String townCounty) {
		this.townCounty = townCounty;
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

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Customer getCustomerBean() {
		return this.customerBean;
	}

	public void setCustomerBean(Customer customerBean) {
		this.customerBean = customerBean;
	}

}