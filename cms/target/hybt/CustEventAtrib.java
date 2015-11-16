// default package
// Generated Apr 21, 2015 7:44:29 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;

/**
 * CustEventAtrib generated by hbm2java
 */
public class CustEventAtrib implements java.io.Serializable {

	private BigDecimal custEventAtrib;
	private BigDecimal custEventAtribValue;
	private BigDecimal custEventAtribType;
	private BigDecimal customerEvent;
	private String valueText;
	private String selectable;
	private String typeName;
	private String canChange;
	private BigDecimal createdBy;
	private BigDecimal updatedBy;
	private BigDecimal orderb;
	private Date created;
	private Date updated;

	public CustEventAtrib() {
	}

	public CustEventAtrib(BigDecimal custEventAtrib) {
		this.custEventAtrib = custEventAtrib;
	}

	public CustEventAtrib(BigDecimal custEventAtrib,
			BigDecimal custEventAtribValue, BigDecimal custEventAtribType,
			BigDecimal customerEvent, String valueText, String selectable,
			String typeName, String canChange, BigDecimal createdBy,
			BigDecimal updatedBy, BigDecimal orderb, Date created, Date updated) {
		this.custEventAtrib = custEventAtrib;
		this.custEventAtribValue = custEventAtribValue;
		this.custEventAtribType = custEventAtribType;
		this.customerEvent = customerEvent;
		this.valueText = valueText;
		this.selectable = selectable;
		this.typeName = typeName;
		this.canChange = canChange;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.orderb = orderb;
		this.created = created;
		this.updated = updated;
	}

	public BigDecimal getCustEventAtrib() {
		return this.custEventAtrib;
	}

	public void setCustEventAtrib(BigDecimal custEventAtrib) {
		this.custEventAtrib = custEventAtrib;
	}

	public BigDecimal getCustEventAtribValue() {
		return this.custEventAtribValue;
	}

	public void setCustEventAtribValue(BigDecimal custEventAtribValue) {
		this.custEventAtribValue = custEventAtribValue;
	}

	public BigDecimal getCustEventAtribType() {
		return this.custEventAtribType;
	}

	public void setCustEventAtribType(BigDecimal custEventAtribType) {
		this.custEventAtribType = custEventAtribType;
	}

	public BigDecimal getCustomerEvent() {
		return this.customerEvent;
	}

	public void setCustomerEvent(BigDecimal customerEvent) {
		this.customerEvent = customerEvent;
	}

	public String getValueText() {
		return this.valueText;
	}

	public void setValueText(String valueText) {
		this.valueText = valueText;
	}

	public String getSelectable() {
		return this.selectable;
	}

	public void setSelectable(String selectable) {
		this.selectable = selectable;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getCanChange() {
		return this.canChange;
	}

	public void setCanChange(String canChange) {
		this.canChange = canChange;
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

	public BigDecimal getOrderb() {
		return this.orderb;
	}

	public void setOrderb(BigDecimal orderb) {
		this.orderb = orderb;
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

}
