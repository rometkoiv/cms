// default package
// Generated Apr 21, 2015 7:44:29 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;

/**
 * OrderType generated by hbm2java
 */
public class OrderType implements java.io.Serializable {

	private BigDecimal orderType;
	private String name;
	private String description;

	public OrderType() {
	}

	public OrderType(BigDecimal orderType) {
		this.orderType = orderType;
	}

	public OrderType(BigDecimal orderType, String name, String description) {
		this.orderType = orderType;
		this.name = name;
		this.description = description;
	}

	public BigDecimal getOrderType() {
		return this.orderType;
	}

	public void setOrderType(BigDecimal orderType) {
		this.orderType = orderType;
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

}
