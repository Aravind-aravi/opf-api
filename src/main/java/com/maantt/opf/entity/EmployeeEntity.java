package com.maantt.opf.entity;



import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employee")

public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer id;
	
	private String first_name;

	private String last_name;

	private String email;

	private String password;

 @OneToMany(targetEntity=ProjectEntity.class,cascade=CascadeType.ALL)
@JoinColumn(name="employee_id",referencedColumnName="id")
 private List<ProjectEntity> projectentity;
 
	public EmployeeEntity() {
			}



	public List<ProjectEntity> getProjectentity() {
		return projectentity;
	}



	public void setProjectentity(List<ProjectEntity> projectentity) {
		this.projectentity = projectentity;
	}



	public EmployeeEntity(Integer id, String first_name, String last_name, String email, String password) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public String getLast_name() {
		return last_name;
	}



	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	
}
