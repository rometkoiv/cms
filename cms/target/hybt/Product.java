// default package
// Generated Apr 21, 2015 7:44:29 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;

/**
 * Product generated by hbm2java
 */
public class Product implements java.io.Serializable {

	private BigDecimal product;
	private BigDecimal enterprise;
	private BigDecimal productType;
	private BigDecimal createdBy;
	private BigDecimal catalog;
	private String code;
	private String code1;
	private String name;
	private String description;
	private Date created;
	private Date updated;
	private BigDecimal updatedBy;
	private BigDecimal price;
	private BigDecimal price2;
	private BigDecimal price3;
	private BigDecimal productStatusType;
	private String producer;

	public Product() {
	}

	public Product(BigDecimal product) {
		this.product = product;
	}

	public Product(BigDecimal product, BigDecimal enterprise,
			BigDecimal productType, BigDecimal createdBy, BigDecimal catalog,
			String code, String code1, String name, String description,
			Date created, Date updated, BigDecimal updatedBy, BigDecimal price,
			BigDecimal price2, BigDecimal price3, BigDecimal productStatusType,
			String producer) {
		this.product = product;
		this.enterprise = enterprise;
		this.productType = productType;
		this.createdBy = createdBy;
		this.catalog = catalog;
		this.code = code;
		this.code1 = code1;
		this.name = name;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.updatedBy = updatedBy;
		this.price = price;
		this.price2 = price2;
		this.price3 = price3;
		this.productStatusType = productStatusType;
		this.producer = producer;
	}

	public BigDecimal getProduct() {
		return this.product;
	}

	public void setProduct(BigDecimal product) {
		this.product = product;
	}

	public BigDecimal getEnterprise() {
		return this.enterprise;
	}

	public void setEnterprise(BigDecimal enterprise) {
		this.enterprise = enterprise;
	}

	public BigDecimal getProductType() {
		return this.productType;
	}

	public void setProductType(BigDecimal productType) {
		this.productType = productType;
	}

	public BigDecimal getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	public BigDecimal getCatalog() {
		return this.catalog;
	}

	public void setCatalog(BigDecimal catalog) {
		this.catalog = catalog;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode1() {
		return this.code1;
	}

	public void setCode1(String code1) {
		this.code1 = code1;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public BigDecimal getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(BigDecimal updatedBy) {
		this.updatedBy = updatedBy;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPrice2() {
		return this.price2;
	}

	public void setPrice2(BigDecimal price2) {
		this.price2 = price2;
	}

	public BigDecimal getPrice3() {
		return this.price3;
	}

	public void setPrice3(BigDecimal price3) {
		this.price3 = price3;
	}

	public BigDecimal getProductStatusType() {
		return this.productStatusType;
	}

	public void setProductStatusType(BigDecimal productStatusType) {
		this.productStatusType = productStatusType;
	}

	public String getProducer() {
		return this.producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

}