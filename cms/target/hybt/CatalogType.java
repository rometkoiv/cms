// default package
// Generated Apr 21, 2015 7:44:29 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;

/**
 * CatalogType generated by hbm2java
 */
public class CatalogType implements java.io.Serializable {

	private BigDecimal catalogType;
	private String name;

	public CatalogType() {
	}

	public CatalogType(BigDecimal catalogType) {
		this.catalogType = catalogType;
	}

	public CatalogType(BigDecimal catalogType, String name) {
		this.catalogType = catalogType;
		this.name = name;
	}

	public BigDecimal getCatalogType() {
		return this.catalogType;
	}

	public void setCatalogType(BigDecimal catalogType) {
		this.catalogType = catalogType;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
