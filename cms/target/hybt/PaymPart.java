// default package
// Generated Apr 21, 2015 7:44:29 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;

/**
 * PaymPart generated by hbm2java
 */
public class PaymPart implements java.io.Serializable {

	private BigDecimal paymPart;
	private BigDecimal paymGraph;
	private BigDecimal paymPartType;
	private BigDecimal paymAmount;

	public PaymPart() {
	}

	public PaymPart(BigDecimal paymPart) {
		this.paymPart = paymPart;
	}

	public PaymPart(BigDecimal paymPart, BigDecimal paymGraph,
			BigDecimal paymPartType, BigDecimal paymAmount) {
		this.paymPart = paymPart;
		this.paymGraph = paymGraph;
		this.paymPartType = paymPartType;
		this.paymAmount = paymAmount;
	}

	public BigDecimal getPaymPart() {
		return this.paymPart;
	}

	public void setPaymPart(BigDecimal paymPart) {
		this.paymPart = paymPart;
	}

	public BigDecimal getPaymGraph() {
		return this.paymGraph;
	}

	public void setPaymGraph(BigDecimal paymGraph) {
		this.paymGraph = paymGraph;
	}

	public BigDecimal getPaymPartType() {
		return this.paymPartType;
	}

	public void setPaymPartType(BigDecimal paymPartType) {
		this.paymPartType = paymPartType;
	}

	public BigDecimal getPaymAmount() {
		return this.paymAmount;
	}

	public void setPaymAmount(BigDecimal paymAmount) {
		this.paymAmount = paymAmount;
	}

}