// default package
// Generated Apr 21, 2015 7:44:29 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;

/**
 * CustomerEvent generated by hbm2java
 */
public class CustomerEvent implements java.io.Serializable {

	private BigDecimal customerEvent;
	private BigDecimal project;
	private BigDecimal structUnit;
	private BigDecimal order;
	private BigDecimal customer;
	private BigDecimal custEventType;
	private String subject;
	private String valueText;
	private Date created;
	private BigDecimal createdBy;
	private Date updated;
	private BigDecimal updatedBy;

	public CustomerEvent() {
	}

	public CustomerEvent(BigDecimal customerEvent) {
		this.customerEvent = customerEvent;
	}

	public CustomerEvent(BigDecimal customerEvent, BigDecimal project,
			BigDecimal structUnit, BigDecimal order, BigDecimal customer,
			BigDecimal custEventType, String subject, String valueText,
			Date created, BigDecimal createdBy, Date updated,
			BigDecimal updatedBy) {
		this.customerEvent = customerEvent;
		this.project = project;
		this.structUnit = structUnit;
		this.order = order;
		this.customer = customer;
		this.custEventType = custEventType;
		this.subject = subject;
		this.valueText = valueText;
		this.created = created;
		this.createdBy = createdBy;
		this.updated = updated;
		this.updatedBy = updatedBy;
	}

	public BigDecimal getCustomerEvent() {
		return this.customerEvent;
	}

	public void setCustomerEvent(BigDecimal customerEvent) {
		this.customerEvent = customerEvent;
	}

	public BigDecimal getProject() {
		return this.project;
	}

	public void setProject(BigDecimal project) {
		this.project = project;
	}

	public BigDecimal getStructUnit() {
		return this.structUnit;
	}

	public void setStructUnit(BigDecimal structUnit) {
		this.structUnit = structUnit;
	}

	public BigDecimal getOrder() {
		return this.order;
	}

	public void setOrder(BigDecimal order) {
		this.order = order;
	}

	public BigDecimal getCustomer() {
		return this.customer;
	}

	public void setCustomer(BigDecimal customer) {
		this.customer = customer;
	}

	public BigDecimal getCustEventType() {
		return this.custEventType;
	}

	public void setCustEventType(BigDecimal custEventType) {
		this.custEventType = custEventType;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getValueText() {
		return this.valueText;
	}

	public void setValueText(String valueText) {
		this.valueText = valueText;
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

	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public BigDecimal getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(BigDecimal updatedBy) {
		this.updatedBy = updatedBy;
	}

}
