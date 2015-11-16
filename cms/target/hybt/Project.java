// default package
// Generated Apr 21, 2015 7:44:29 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;

/**
 * Project generated by hbm2java
 */
public class Project implements java.io.Serializable {

	private BigDecimal project;
	private BigDecimal projectStatusType;
	private BigDecimal projectType;
	private BigDecimal structUnit;
	private BigDecimal manager;
	private Date lastStatusChange;
	private String name;
	private String description;

	public Project() {
	}

	public Project(BigDecimal project) {
		this.project = project;
	}

	public Project(BigDecimal project, BigDecimal projectStatusType,
			BigDecimal projectType, BigDecimal structUnit, BigDecimal manager,
			Date lastStatusChange, String name, String description) {
		this.project = project;
		this.projectStatusType = projectStatusType;
		this.projectType = projectType;
		this.structUnit = structUnit;
		this.manager = manager;
		this.lastStatusChange = lastStatusChange;
		this.name = name;
		this.description = description;
	}

	public BigDecimal getProject() {
		return this.project;
	}

	public void setProject(BigDecimal project) {
		this.project = project;
	}

	public BigDecimal getProjectStatusType() {
		return this.projectStatusType;
	}

	public void setProjectStatusType(BigDecimal projectStatusType) {
		this.projectStatusType = projectStatusType;
	}

	public BigDecimal getProjectType() {
		return this.projectType;
	}

	public void setProjectType(BigDecimal projectType) {
		this.projectType = projectType;
	}

	public BigDecimal getStructUnit() {
		return this.structUnit;
	}

	public void setStructUnit(BigDecimal structUnit) {
		this.structUnit = structUnit;
	}

	public BigDecimal getManager() {
		return this.manager;
	}

	public void setManager(BigDecimal manager) {
		this.manager = manager;
	}

	public Date getLastStatusChange() {
		return this.lastStatusChange;
	}

	public void setLastStatusChange(Date lastStatusChange) {
		this.lastStatusChange = lastStatusChange;
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
