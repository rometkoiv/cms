package cms.backend.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.sql.Timestamp;


/**
 * The persistent class for the customer_group database table.
 * 
 */
@Entity
@Table(name="customer_group")
@NamedQueries({
@NamedQuery(name="CustomerGroup.findByID", query="SELECT c FROM CustomerGroup c where c.customerGroup=:id"),
@NamedQuery(name="CustomerGroup.findAll", query="SELECT c FROM CustomerGroup c where c.customerBean.customer=:customer")
})
@JsonIdentityInfo(generator = ObjectIdGenerators.None.class ,property = "@id")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_group")
	private long customerGroup;

	private Timestamp created;

	@Column(name="created_by")
	private Long createdBy;

	//bi-directional many-to-one association to CGroup
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.DETACH)
	@JsonIgnore
	@JoinColumn(name="c_group")
	private CGroup CGroup;

	//bi-directional many-to-one association to Customer
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.DETACH)
	@JsonIgnore
	@JoinColumn(name="customer")
	private Customer customerBean;

	public CustomerGroup() {
	}

	public long getCustomerGroup() {
		return this.customerGroup;
	}

	public void setCustomerGroup(long customerGroup) {
		this.customerGroup = customerGroup;
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

	public CGroup getCGroup() {
		return this.CGroup;
	}

	public void setCGroup(CGroup CGroup) {
		this.CGroup = CGroup;
	}

	public Customer getCustomerBean() {
		return this.customerBean;
	}

	public void setCustomerBean(Customer customerBean) {
		this.customerBean = customerBean;
	}

}