// default package
// Generated Apr 21, 2015 7:44:29 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;

/**
 * CustomerAtrTypeValue generated by hbm2java
 */
public class CustomerAtrTypeValue implements java.io.Serializable {

	private BigDecimal customerAtrTypeValue;
	private BigDecimal customerAtrType;
	private String valueText;
	private BigDecimal orderb;
	private String active;
	private Date created;
	private Date updated;
	private BigDecimal createdBy;
	private BigDecimal updatedBy;

	public CustomerAtrTypeValue() {
	}

	public CustomerAtrTypeValue(BigDecimal customerAtrTypeValue) {
		this.customerAtrTypeValue = customerAtrTypeValue;
	}

	public CustomerAtrTypeValue(BigDecimal customerAtrTypeValue,
			BigDecimal customerAtrType, String valueText, BigDecimal orderb,
			String active, Date created, Date updated, BigDecimal createdBy,
			BigDecimal updatedBy) {
		this.customerAtrTypeValue = customerAtrTypeValue;
		this.customerAtrType = customerAtrType;
		this.valueText = valueText;
		this.orderb = orderb;
		this.active = active;
		this.created = created;
		this.updated = updated;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public BigDecimal getCustomerAtrTypeValue() {
		return this.customerAtrTypeValue;
	}

	public void setCustomerAtrTypeValue(BigDecimal customerAtrTypeValue) {
		this.customerAtrTypeValue = customerAtrTypeValue;
	}

	public BigDecimal getCustomerAtrType() {
		return this.customerAtrType;
	}

	public void setCustomerAtrType(BigDecimal customerAtrType) {
		this.customerAtrType = customerAtrType;
	}

	public String getValueText() {
		return this.valueText;
	}

	public void setValueText(String valueText) {
		this.valueText = valueText;
	}

	public BigDecimal getOrderb() {
		return this.orderb;
	}

	public void setOrderb(BigDecimal orderb) {
		this.orderb = orderb;
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public BigDecimal getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	public BigDecimal getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(BigDecimal updatedBy) {
		this.updatedBy = updatedBy;
	}

}
