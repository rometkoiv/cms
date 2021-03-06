// default package
// Generated Apr 21, 2015 7:44:29 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;

/**
 * ProjectRelationType generated by hbm2java
 */
public class ProjectRelationType implements java.io.Serializable {

	private BigDecimal projectRelationType;
	private String name;

	public ProjectRelationType() {
	}

	public ProjectRelationType(BigDecimal projectRelationType) {
		this.projectRelationType = projectRelationType;
	}

	public ProjectRelationType(BigDecimal projectRelationType, String name) {
		this.projectRelationType = projectRelationType;
		this.name = name;
	}

	public BigDecimal getProjectRelationType() {
		return this.projectRelationType;
	}

	public void setProjectRelationType(BigDecimal projectRelationType) {
		this.projectRelationType = projectRelationType;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
