// default package
// Generated Apr 21, 2015 7:44:29 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;

/**
 * ContractStatus generated by hbm2java
 */
public class ContractStatus implements java.io.Serializable {

	private BigDecimal contractStatus;
	private BigDecimal contract;
	private BigDecimal contractStatusType;
	private Date validFrom;
	private Date validTo;
	private BigDecimal status;
	private Date created;
	private BigDecimal createdBy;
	private Date ended;
	private BigDecimal endedBy;

	public ContractStatus() {
	}

	public ContractStatus(BigDecimal contractStatus) {
		this.contractStatus = contractStatus;
	}

	public ContractStatus(BigDecimal contractStatus, BigDecimal contract,
			BigDecimal contractStatusType, Date validFrom, Date validTo,
			BigDecimal status, Date created, BigDecimal createdBy, Date ended,
			BigDecimal endedBy) {
		this.contractStatus = contractStatus;
		this.contract = contract;
		this.contractStatusType = contractStatusType;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.status = status;
		this.created = created;
		this.createdBy = createdBy;
		this.ended = ended;
		this.endedBy = endedBy;
	}

	public BigDecimal getContractStatus() {
		return this.contractStatus;
	}

	public void setContractStatus(BigDecimal contractStatus) {
		this.contractStatus = contractStatus;
	}

	public BigDecimal getContract() {
		return this.contract;
	}

	public void setContract(BigDecimal contract) {
		this.contract = contract;
	}

	public BigDecimal getContractStatusType() {
		return this.contractStatusType;
	}

	public void setContractStatusType(BigDecimal contractStatusType) {
		this.contractStatusType = contractStatusType;
	}

	public Date getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return this.validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
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

	public Date getEnded() {
		return this.ended;
	}

	public void setEnded(Date ended) {
		this.ended = ended;
	}

	public BigDecimal getEndedBy() {
		return this.endedBy;
	}

	public void setEndedBy(BigDecimal endedBy) {
		this.endedBy = endedBy;
	}

}
