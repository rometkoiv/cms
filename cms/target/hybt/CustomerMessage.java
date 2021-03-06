// default package
// Generated Apr 21, 2015 7:44:29 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;

/**
 * CustomerMessage generated by hbm2java
 */
public class CustomerMessage implements java.io.Serializable {

	private BigDecimal customerMessage;
	private BigDecimal custMessageType;
	private BigDecimal customer;
	private BigDecimal custMessageStatusType;
	private String subject;
	private String valueText;
	private BigDecimal orderb;
	private Date created;
	private BigDecimal createdBy;
	private Date showStart;
	private Date showEnd;

	public CustomerMessage() {
	}

	public CustomerMessage(BigDecimal customerMessage) {
		this.customerMessage = customerMessage;
	}

	public CustomerMessage(BigDecimal customerMessage,
			BigDecimal custMessageType, BigDecimal customer,
			BigDecimal custMessageStatusType, String subject, String valueText,
			BigDecimal orderb, Date created, BigDecimal createdBy,
			Date showStart, Date showEnd) {
		this.customerMessage = customerMessage;
		this.custMessageType = custMessageType;
		this.customer = customer;
		this.custMessageStatusType = custMessageStatusType;
		this.subject = subject;
		this.valueText = valueText;
		this.orderb = orderb;
		this.created = created;
		this.createdBy = createdBy;
		this.showStart = showStart;
		this.showEnd = showEnd;
	}

	public BigDecimal getCustomerMessage() {
		return this.customerMessage;
	}

	public void setCustomerMessage(BigDecimal customerMessage) {
		this.customerMessage = customerMessage;
	}

	public BigDecimal getCustMessageType() {
		return this.custMessageType;
	}

	public void setCustMessageType(BigDecimal custMessageType) {
		this.custMessageType = custMessageType;
	}

	public BigDecimal getCustomer() {
		return this.customer;
	}

	public void setCustomer(BigDecimal customer) {
		this.customer = customer;
	}

	public BigDecimal getCustMessageStatusType() {
		return this.custMessageStatusType;
	}

	public void setCustMessageStatusType(BigDecimal custMessageStatusType) {
		this.custMessageStatusType = custMessageStatusType;
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

	public BigDecimal getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	public Date getShowStart() {
		return this.showStart;
	}

	public void setShowStart(Date showStart) {
		this.showStart = showStart;
	}

	public Date getShowEnd() {
		return this.showEnd;
	}

	public void setShowEnd(Date showEnd) {
		this.showEnd = showEnd;
	}

}
