package cms.backend.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.sql.Timestamp;


/**
 * The persistent class for the comm_device database table.
 * 
 */
@Entity
@Table(name="comm_device")
@NamedQueries({
@NamedQuery(name="CommDevice.findByID", query="SELECT c FROM CommDevice c where c.commDevice = :id"),
@NamedQuery(name="CommDevice.findAll", query="SELECT c FROM CommDevice c"),
@NamedQuery(name="CommDevice.findByCustomer", query="SELECT c FROM CommDevice c where c.customerBean.customer=:customer order by c.orderb ASC")
})
@JsonIdentityInfo(generator = ObjectIdGenerators.None.class ,property = "@id")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommDevice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty("commDevice")
	@Column(name="comm_device")
	private long commDevice;

	private Timestamp created;
	
	@JsonProperty("orderb")
	private Long orderb;
    
	@Column(name="value_text")
	@JsonProperty("valueText")
	private String valueText;

	//bi-directional many-to-one association to Customer
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JsonIgnore
	@JoinColumn(name="customer")
	private Customer customerBean;

	//bi-directional one-to-one association to CommDeviceType
	@JsonProperty("commDeviceType")
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name="comm_device_type")
	private CommDeviceType commDeviceTypeBean;

	public CommDevice() {
	}

	public long getCommDevice() {
		return this.commDevice;
	}

	public void setCommDevice(long commDevice) {
		this.commDevice = commDevice;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Long getOrderb() {
		return this.orderb;
	}

	public void setOrderb(Long orderb) {
		this.orderb = orderb;
	}

	public String getValueText() {
		return this.valueText;
	}

	public void setValueText(String valueText) {
		this.valueText = valueText;
	}

	public Customer getCustomerBean() {
		return this.customerBean;
	}

	public void setCustomerBean(Customer customerBean) {
		this.customerBean = customerBean;
	}

	public CommDeviceType getCommDeviceTypeBean() {
		return this.commDeviceTypeBean;
	}

	public void setCommDeviceTypeBean(CommDeviceType commDeviceTypeBean) {
		this.commDeviceTypeBean = commDeviceTypeBean;
	}

}