// default package
// Generated Apr 21, 2015 7:44:29 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;

/**
 * EnterpriseCustomer generated by hbm2java
 */
public class EnterpriseCustomer implements java.io.Serializable {

	private BigDecimal enterpriseCustomer;
	private BigDecimal customer;
	private BigDecimal enterprise;
	private Date created;
	private BigDecimal createdBy;
	private BigDecimal relationType;
	private String note;

	public EnterpriseCustomer() {
	}

	public EnterpriseCustomer(BigDecimal enterpriseCustomer) {
		this.enterpriseCustomer = enterpriseCustomer;
	}

	public EnterpriseCustomer(BigDecimal enterpriseCustomer,
			BigDecimal customer, BigDecimal enterprise, Date created,
			BigDecimal createdBy, BigDecimal relationType, String note) {
		this.enterpriseCustomer = enterpriseCustomer;
		this.customer = customer;
		this.enterprise = enterprise;
		this.created = created;
		this.createdBy = createdBy;
		this.relationType = relationType;
		this.note = note;
	}

	public BigDecimal getEnterpriseCustomer() {
		return this.enterpriseCustomer;
	}

	public void setEnterpriseCustomer(BigDecimal enterpriseCustomer) {
		this.enterpriseCustomer = enterpriseCustomer;
	}

	public BigDecimal getCustomer() {
		return this.customer;
	}

	public void setCustomer(BigDecimal customer) {
		this.customer = customer;
	}

	public BigDecimal getEnterprise() {
		return this.enterprise;
	}

	public void setEnterprise(BigDecimal enterprise) {
		this.enterprise = enterprise;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public BigDecimal getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	public BigDecimal getRelationType() {
		return this.relationType;
	}

	public void setRelationType(BigDecimal relationType) {
		this.relationType = relationType;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}