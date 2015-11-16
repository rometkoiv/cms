package cms.backend.model;

import java.sql.Timestamp;

public class GroupWithCustomer {
	private String name;
	private String description;
	private Long group;
	private Long link;
	private Long customer;
	private Timestamp created;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getGroup() {
		return group;
	}
	public void setGroup(Long group) {
		this.group = group;
	}
	public Long getCustomer() {
		return customer;
	}
	public void setCustomer(Long customer) {
		this.customer = customer;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public Long getLink() {
		return link;
	}
	public void setLink(Long link) {
		this.link = link;
	}
	
	
}
