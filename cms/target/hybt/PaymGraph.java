// default package
// Generated Apr 21, 2015 7:44:29 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;

/**
 * PaymGraph generated by hbm2java
 */
public class PaymGraph implements java.io.Serializable {

	private BigDecimal paymGraph;
	private BigDecimal paymentType;
	private BigDecimal customer;
	private BigDecimal order;
	private BigDecimal paymentTotal;
	private Date dueDate;
	private Date created;
	private BigDecimal createdBy;
	private Date updated;
	private BigDecimal updatedBy;
	private BigDecimal contract;
	private BigDecimal status;

	public PaymGraph() {
	}

	public PaymGraph(BigDecimal paymGraph) {
		this.paymGraph = paymGraph;
	}

	public PaymGraph(BigDecimal paymGraph, BigDecimal paymentType,
			BigDecimal customer, BigDecimal order, BigDecimal paymentTotal,
			Date dueDate, Date created, BigDecimal createdBy, Date updated,
			BigDecimal updatedBy, BigDecimal contract, BigDecimal status) {
		this.paymGraph = paymGraph;
		this.paymentType = paymentType;
		this.customer = customer;
		this.order = order;
		this.paymentTotal = paymentTotal;
		this.dueDate = dueDate;
		this.created = created;
		this.createdBy = createdBy;
		this.updated = updated;
		this.updatedBy = updatedBy;
		this.contract = contract;
		this.status = status;
	}

	public BigDecimal getPaymGraph() {
		return this.paymGraph;
	}

	public void setPaymGraph(BigDecimal paymGraph) {
		this.paymGraph = paymGraph;
	}

	public BigDecimal getPaymentType() {
		return this.paymentType;
	}

	public void setPaymentType(BigDecimal paymentType) {
		this.paymentType = paymentType;
	}

	public BigDecimal getCustomer() {
		return this.customer;
	}

	public void setCustomer(BigDecimal customer) {
		this.customer = customer;
	}

	public BigDecimal getOrder() {
		return this.order;
	}

	public void setOrder(BigDecimal order) {
		this.order = order;
	}

	public BigDecimal getPaymentTotal() {
		return this.paymentTotal;
	}

	public void setPaymentTotal(BigDecimal paymentTotal) {
		this.paymentTotal = paymentTotal;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
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

	public BigDecimal getContract() {
		return this.contract;
	}

	public void setContract(BigDecimal contract) {
		this.contract = contract;
	}

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

}
