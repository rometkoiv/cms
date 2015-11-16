package cms.backend.model;


import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

public class ClientSearch {
	private boolean strict; 
	
   //Customer
	
	private Long customer;
	private String firstName;
	private String lastName;
	private String identityCode;
	private String note;
	private Timestamp birthDate;
	@Past(message="Tulevik ei sobi")
	@DateTimeFormat(pattern = "dd.mm.yyyy")
	private Date birthFrom;
	@Past(message="Tulevik ei sobi")
	@DateTimeFormat(pattern = "dd.mm.yyyy")
	private Date birthTo;
	private Timestamp created;
	@Past(message="Tulevik ei sobi")
	@DateTimeFormat(pattern = "dd.mm.yyyy")
	private Date createdFrom;
	@Past(message="Tulevik ei sobi")
	@DateTimeFormat(pattern = "dd.mm.yyyy") 
	private Date createdTo;
	private List<Long> createdBy;
	private String createdByName;
	@Past(message="Tulevik ei sobi")
	@DateTimeFormat(pattern = "dd.mm.yyyy")
	private Date updatedFrom;
	@Past(message="Tulevik ei sobi")
	@DateTimeFormat(pattern = "dd.mm.yyyy")
	private Date updatedTo;
	private Timestamp updated;
	private List<Long> updatedBy;
	private String updatedByName;
	
	//CGroup
	private String cgName;
	private List<Long> cgGroup;
	//CstAddress
	private Long cstAddress;
	private String address;
	private Long addressType;
	private String house;
	private String townCounty;
	private String county;
	private String zip;
	//CommDeviceType
    private String commDevTypeName;
    private Long commDeviceType;
    //CommDevice
    private String commDevName;
    private Long commDev;
    //Muud
    private boolean logsql;
    private String sort;
    private String orderby;
    //SetteridJaGetterid
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
	public String getIdentityCode() {
		return identityCode;
	}
	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public List<Long> getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(List<Long> createdBy) {
		this.createdBy = createdBy;
	}
		
	public List<Long> getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(List<Long> updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getCgName() {
		return cgName;
	}
	public void setCgName(String cgName) {
		this.cgName = cgName;
	}
	public List<Long> getCgGroup() {
		return cgGroup;
	}
	public void setCgGroup(List<Long> cgGroup) {
		this.cgGroup = cgGroup;
	}
	public Long getCstAddress() {
		return cstAddress;
	}
	public void setCstAddress(Long cstAddress) {
		this.cstAddress = cstAddress;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getAddressType() {
		return addressType;
	}
	public void setAddressType(Long addressType) {
		this.addressType = addressType;
	}
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	public String getTownCounty() {
		return townCounty;
	}
	public void setTownCounty(String townCounty) {
		this.townCounty = townCounty;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCommDevTypeName() {
		return commDevTypeName;
	}
	public void setCommDevTypeName(String commDevTypeName) {
		this.commDevTypeName = commDevTypeName;
	}
	public Long getCommDeviceType() {
		return commDeviceType;
	}
	public void setCommDeviceType(Long commDeviceType) {
		this.commDeviceType = commDeviceType;
	}
	public String getCommDevName() {
		return commDevName;
	}
	public void setCommDevName(String commDevName) {
		this.commDevName = commDevName;
	}
	public Long getCommDev() {
		return commDev;
	}
	public void setCommDev(Long commDev) {
		this.commDev = commDev;
	}
	public Long getCustomer() {
		return customer;
	}
	public void setCustomer(Long customer) {
		this.customer = customer;
	}
	public boolean getStrict() {
		return strict;
	}
	public void setStrict(boolean strict) {
		this.strict = strict;
	}
	public String getCreatedByName() {
		return createdByName;
	}
	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}
	public String getUpdatedByName() {
		return updatedByName;
	}
	public void setUpdatedByName(String updatedByName) {
		this.updatedByName = updatedByName;
	}
	public Date getCreatedFrom() {
		return createdFrom;
	}
	public void setCreatedFrom(Date createdFrom) {
		this.createdFrom = createdFrom;
	}
	public Date getCreatedTo() {
		return createdTo;
	}
	public void setCreatedTo(Date createdTo) {
		this.createdTo = createdTo;
	}
	public Date getBirthFrom() {
		return birthFrom;
	}
	public void setBirthFrom(Date birthFrom) {
		this.birthFrom = birthFrom;
	}
	public Date getBirthTo() {
		return birthTo;
	}
	public void setBirthTo(Date birthTo) {
		this.birthTo = birthTo;
	}
	public Date getUpdatedFrom() {
		return updatedFrom;
	}
	public void setUpdatedFrom(Date updatedFrom) {
		this.updatedFrom = updatedFrom;
	}
	public Date getUpdatedTo() {
		return updatedTo;
	}
	public void setUpdatedTo(Date updatedTo) {
		this.updatedTo = updatedTo;
	}
	public Timestamp getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
	}
	public Timestamp getUpdated() {
		return updated;
	}
	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public boolean isLogsql() {
		return logsql;
	}
	public void setLogsql(boolean logsql) {
		this.logsql = logsql;
	}
	public String getOrderby() {
		return orderby;
	}
	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	
}
