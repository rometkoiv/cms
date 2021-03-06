// default package
// Generated Apr 21, 2015 7:44:29 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;

/**
 * ProjectStatusType generated by hbm2java
 */
public class ProjectStatusType implements java.io.Serializable {

	private BigDecimal projectStatusType;
	private String name;
	private String description;

	public ProjectStatusType() {
	}

	public ProjectStatusType(BigDecimal projectStatusType) {
		this.projectStatusType = projectStatusType;
	}

	public ProjectStatusType(BigDecimal projectStatusType, String name,
			String description) {
		this.projectStatusType = projectStatusType;
		this.name = name;
		this.description = description;
	}

	public BigDecimal getProjectStatusType() {
		return this.projectStatusType;
	}

	public void setProjectStatusType(BigDecimal projectStatusType) {
		this.projectStatusType = projectStatusType;
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
