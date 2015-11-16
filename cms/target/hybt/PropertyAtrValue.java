// default package
// Generated Apr 21, 2015 7:44:29 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;

/**
 * PropertyAtrValue generated by hbm2java
 */
public class PropertyAtrValue implements java.io.Serializable {

	private BigDecimal propertyAtrValue;
	private BigDecimal propertyAtrType;
	private String valueText;
	private BigDecimal orderb;
	private String active;
	private Date created;
	private Date updated;
	private BigDecimal createdBy;
	private BigDecimal updatedBy;

	public PropertyAtrValue() {
	}

	public PropertyAtrValue(BigDecimal propertyAtrValue) {
		this.propertyAtrValue = propertyAtrValue;
	}

	public PropertyAtrValue(BigDecimal propertyAtrValue,
			BigDecimal propertyAtrType, String valueText, BigDecimal orderb,
			String active, Date created, Date updated, BigDecimal createdBy,
			BigDecimal updatedBy) {
		this.propertyAtrValue = propertyAtrValue;
		this.propertyAtrType = propertyAtrType;
		this.valueText = valueText;
		this.orderb = orderb;
		this.active = active;
		this.created = created;
		this.updated = updated;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public BigDecimal getPropertyAtrValue() {
		return this.propertyAtrValue;
	}

	public void setPropertyAtrValue(BigDecimal propertyAtrValue) {
		this.propertyAtrValue = propertyAtrValue;
	}

	public BigDecimal getPropertyAtrType() {
		return this.propertyAtrType;
	}

	public void setPropertyAtrType(BigDecimal propertyAtrType) {
		this.propertyAtrType = propertyAtrType;
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
