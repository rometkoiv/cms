package cms.backend.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * The persistent class for the comm_device_type database table.
 * 
 */
@Entity
@Table(name="comm_device_type")
@NamedQueries({
@NamedQuery(name="CommDeviceType.findByID", query="SELECT c FROM CommDeviceType c where c.commDeviceType=:id"),
@NamedQuery(name="CommDeviceType.findAll", query="SELECT c FROM CommDeviceType c"),
@NamedQuery(name="CommDeviceType.findInUse", query="SELECT c FROM CommDeviceType c, CommDevice d where d.commDeviceTypeBean.commDeviceType=c.commDeviceType and c.commDeviceType=:id")
})
@JsonIdentityInfo(generator = ObjectIdGenerators.None.class ,property = "@id")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommDeviceType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty("commDeviceType")
	@Column(name="comm_device_type")
	private long commDeviceType;
    
	@JsonProperty("description")
	private String description;
    
	@NotEmpty(message="Ei tohi olla tühi")
	@JsonProperty("name")
	private String name;

	//bi-directional one-to-one association to CommDevice
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name="comm_device_type", referencedColumnName="comm_device_type")
	@JsonIgnore
	private CommDevice commDevice;

	public CommDeviceType() {
	}

	public long getCommDeviceType() {
		return this.commDeviceType;
	}

	public void setCommDeviceType(long commDeviceType) {
		this.commDeviceType = commDeviceType;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CommDevice getCommDevice() {
		return this.commDevice;
	}

	public void setCommDevice(CommDevice commDevice) {
		this.commDevice = commDevice;
	}

}