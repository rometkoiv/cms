// default package
// Generated Apr 21, 2015 7:44:29 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;

/**
 * ProductProductCatalog generated by hbm2java
 */
public class ProductProductCatalog implements java.io.Serializable {

	private BigDecimal productProductCatalog;
	private BigDecimal productCatalog;
	private BigDecimal product;
	private String note;
	private BigDecimal relationType;
	private Date created;
	private BigDecimal createdBy;
	private Date deleted;
	private BigDecimal deletedBy;

	public ProductProductCatalog() {
	}

	public ProductProductCatalog(BigDecimal productProductCatalog) {
		this.productProductCatalog = productProductCatalog;
	}

	public ProductProductCatalog(BigDecimal productProductCatalog,
			BigDecimal productCatalog, BigDecimal product, String note,
			BigDecimal relationType, Date created, BigDecimal createdBy,
			Date deleted, BigDecimal deletedBy) {
		this.productProductCatalog = productProductCatalog;
		this.productCatalog = productCatalog;
		this.product = product;
		this.note = note;
		this.relationType = relationType;
		this.created = created;
		this.createdBy = createdBy;
		this.deleted = deleted;
		this.deletedBy = deletedBy;
	}

	public BigDecimal getProductProductCatalog() {
		return this.productProductCatalog;
	}

	public void setProductProductCatalog(BigDecimal productProductCatalog) {
		this.productProductCatalog = productProductCatalog;
	}

	public BigDecimal getProductCatalog() {
		return this.productCatalog;
	}

	public void setProductCatalog(BigDecimal productCatalog) {
		this.productCatalog = productCatalog;
	}

	public BigDecimal getProduct() {
		return this.product;
	}

	public void setProduct(BigDecimal product) {
		this.product = product;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public BigDecimal getRelationType() {
		return this.relationType;
	}

	public void setRelationType(BigDecimal relationType) {
		this.relationType = relationType;
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

	public Date getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Date deleted) {
		this.deleted = deleted;
	}

	public BigDecimal getDeletedBy() {
		return this.deletedBy;
	}

	public void setDeletedBy(BigDecimal deletedBy) {
		this.deletedBy = deletedBy;
	}

}
