package cms.backend.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class CommDevAndType {
     private Long commDevice;
     @NotNull(message="Ilma tüübita ei saa")
     private Long commDeviceType;
     private Long orderb;
     
     @NotEmpty(message="Ei tohi olla tühi")
     private String valueText;
     private String typeName;
     private String typeDescription;
     private Long customer;
	public Long getCommDevice() {
		return commDevice;
	}
	public void setCommDevice(Long commDevice) {
		this.commDevice = commDevice;
	}
	public Long getCommDeviceType() {
		return commDeviceType;
	}
	public void setCommDeviceType(Long commDeviceType) {
		this.commDeviceType = commDeviceType;
	}
	public Long getOrderb() {
		return orderb;
	}
	public void setOrderb(Long orderb) {
		this.orderb = orderb;
	}
	public String getValueText() {
		return valueText;
	}
	public void setValueText(String valueText) {
		this.valueText = valueText;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTypeDescription() {
		return typeDescription;
	}
	public void setTypeDescription(String typeDescription) {
		this.typeDescription = typeDescription;
	}
	public Long getCustomer() {
		return customer;
	}
	public void setCustomer(Long customer) {
		this.customer = customer;
	}
}
