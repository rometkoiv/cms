// default package
// Generated Apr 21, 2015 7:44:29 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;

/**
 * ContractRelation generated by hbm2java
 */
public class ContractRelation implements java.io.Serializable {

	private BigDecimal contractRelation;
	private BigDecimal contract;
	private BigDecimal contract1;
	private BigDecimal relationType;
	private Date validFrom;
	private Date validTo;
	private Date created;
	private BigDecimal createdBy;
	private Date updated;
	private BigDecimal updatedBy;
	private BigDecimal status;

	public ContractRelation() {
	}

	public ContractRelation(BigDecimal contractRelation) {
		this.contractRelation = contractRelation;
	}

	public ContractRelation(BigDecimal contractRelation, BigDecimal contract,
			BigDecimal contract1, BigDecimal relationType, Date validFrom,
			Date validTo, Date created, BigDecimal createdBy, Date updated,
			BigDecimal updatedBy, BigDecimal status) {
		this.contractRelation = contractRelation;
		this.contract = contract;
		this.contract1 = contract1;
		this.relationType = relationType;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.created = created;
		this.createdBy = createdBy;
		this.updated = updated;
		this.updatedBy = updatedBy;
		this.status = status;
	}

	public BigDecimal getContractRelation() {
		return this.contractRelation;
	}

	public void setContractRelation(BigDecimal contractRelation) {
		this.contractRelation = contractRelation;
	}

	public BigDecimal getContract() {
		return this.contract;
	}

	public void setContract(BigDecimal contract) {
		this.contract = contract;
	}

	public BigDecimal getContract1() {
		return this.contract1;
	}

	public void setContract1(BigDecimal contract1) {
		this.contract1 = contract1;
	}

	public BigDecimal getRelationType() {
		return this.relationType;
	}

	public void setRelationType(BigDecimal relationType) {
		this.relationType = relationType;
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

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

}
