package cms.backend.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the c_group database table.
 * 
 */
@Entity
@Table(name="c_group")
@NamedQueries({
@NamedQuery(name="CGroup.findAll", query="SELECT c FROM CGroup c"),
@NamedQuery(name="CGroup.findByID", query="SELECT c FROM CGroup c where c.cGroup=:id"),
@NamedQuery(name="CGroup.findInUse", query="SELECT c FROM CGroup c, CustomerGroup d where d.CGroup.cGroup = c.cGroup and c.cGroup=:id")
})
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.None.class ,property = "@id")
public class CGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="c_group")
	private long cGroup;

	private Timestamp created;

	@Column(name="created_by")
	private Long createdBy;
    
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("name")
	private String name;

	@Column(name="struct_unit")
	private BigDecimal structUnit;

	private Timestamp updated;

	@Column(name="updated_by")
	private Long updatedBy;

	//bi-directional many-to-one association to CustomerGroup
	@OneToMany(mappedBy="CGroup",fetch=FetchType.EAGER,cascade = CascadeType.DETACH)
	@JsonManagedReference
	private List<CustomerGroup> customerGroups;

	public CGroup() {
	}

	public long getCGroup() {
		return this.cGroup;
	}

	public void setCGroup(long cGroup) {
		this.cGroup = cGroup;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
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

	public BigDecimal getStructUnit() {
		return this.structUnit;
	}

	public void setStructUnit(BigDecimal structUnit) {
		this.structUnit = structUnit;
	}

	public Timestamp getUpdated() {
		return this.updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public List<CustomerGroup> getCustomerGroups() {
		return this.customerGroups;
	}

	public void setCustomerGroups(List<CustomerGroup> customerGroups) {
		this.customerGroups = customerGroups;
	}

	public CustomerGroup addCustomerGroup(CustomerGroup customerGroup) {
		getCustomerGroups().add(customerGroup);
		customerGroup.setCGroup(this);

		return customerGroup;
	}

	public CustomerGroup removeCustomerGroup(CustomerGroup customerGroup) {
		getCustomerGroups().remove(customerGroup);
		customerGroup.setCGroup(null);

		return customerGroup;
	}

}