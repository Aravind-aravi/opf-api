package com.maantt.opf.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="project")

public class ProjectEntity {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer id;
	
	private String head_line;

	private String summary;

	private String skill;

	private Character status;
	
    private Integer employee_id;
    

    @OneToMany(targetEntity=UserEntity.class,cascade=CascadeType.ALL)
   @JoinColumn(name="project_id",referencedColumnName="id")
    private List<UserEntity> userentity;

    @OneToMany(targetEntity=ContributedUserEntity.class,cascade=CascadeType.ALL)
   @JoinColumn(name="project_id",referencedColumnName="id")
    private List<ContributedUserEntity> contributeduserentity;


	public ProjectEntity() {
		}
	
	



	public ProjectEntity(Integer id, String head_line, String summary, String skill, Character status) {
		super();
		this.id = id;
		this.head_line = head_line;
		this.summary = summary;
		this.skill = skill;
		this.status = status;
	}

	




	public List<ContributedUserEntity> getContributeduserentity() {
		return contributeduserentity;
	}





	public void setContributeduserentity(List<ContributedUserEntity> contributeduserentity) {
		this.contributeduserentity = contributeduserentity;
	}





	public List<UserEntity> getUserentity() {
		return userentity;
	}





	public void setUserentity(List<UserEntity> userentity) {
		this.userentity = userentity;
	}





	public Integer getEmployee_id() {
		return employee_id;
	}





	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}





	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getHead_line() {
		return head_line;
	}


	public void setHead_line(String head_line) {
		this.head_line = head_line;
	}


	public String getSummary() {
		return summary;
	}


	public void setSummary(String summary) {
		this.summary = summary;
	}


	public String getSkill() {
		return skill;
	}


	public void setSkill(String skill) {
		this.skill = skill;
	}


	public Character getStatus() {
		return status;
	}


	public void setStatus(Character status) {
		this.status = status;
	}

		
}
