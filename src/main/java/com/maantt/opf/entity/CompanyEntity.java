package com.maantt.opf.entity;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="company")

public class CompanyEntity {
    @Id
	private Integer id;
	private String name;
	
	@OneToMany(targetEntity = EmployeeEntity.class,cascade = CascadeType.ALL)
	@JoinColumn(name="company_id",referencedColumnName="id")
	private List<EmployeeEntity>  employeeentity;
	
	

	public CompanyEntity() {
			}


	public CompanyEntity(Integer id, String name, List<EmployeeEntity> employeeentity) {
		super();
		this.id = id;
		this.name = name;
		this.employeeentity = employeeentity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EmployeeEntity> getEmployeeentity() {
		return employeeentity;
	}

	public void setEmployeeentity(List<EmployeeEntity> employeeentity) {
		this.employeeentity = employeeentity;
	}
	
	
}
