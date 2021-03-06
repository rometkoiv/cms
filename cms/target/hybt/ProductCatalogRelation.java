// default package
// Generated Apr 21, 2015 7:44:29 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;

/**
 * ProductCatalogRelation generated by hbm2java
 */
public class ProductCatalogRelation implements java.io.Serializable {

	private BigDecimal productCatalogRelation;
	private BigDecimal upperCatalog;
	private BigDecimal lowerCatalog;
	private String note;
	private BigDecimal relationType;

	public ProductCatalogRelation() {
	}

	public ProductCatalogRelation(BigDecimal productCatalogRelation) {
		this.productCatalogRelation = productCatalogRelation;
	}

	public ProductCatalogRelation(BigDecimal productCatalogRelation,
			BigDecimal upperCatalog, BigDecimal lowerCatalog, String note,
			BigDecimal relationType) {
		this.productCatalogRelation = productCatalogRelation;
		this.upperCatalog = upperCatalog;
		this.lowerCatalog = lowerCatalog;
		this.note = note;
		this.relationType = relationType;
	}

	public BigDecimal getProductCatalogRelation() {
		return this.productCatalogRelation;
	}

	public void setProductCatalogRelation(BigDecimal productCatalogRelation) {
		this.productCatalogRelation = productCatalogRelation;
	}

	public BigDecimal getUpperCatalog() {
		return this.upperCatalog;
	}

	public void setUpperCatalog(BigDecimal upperCatalog) {
		this.upperCatalog = upperCatalog;
	}

	public BigDecimal getLowerCatalog() {
		return this.lowerCatalog;
	}

	public void setLowerCatalog(BigDecimal lowerCatalog) {
		this.lowerCatalog = lowerCatalog;
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

}
