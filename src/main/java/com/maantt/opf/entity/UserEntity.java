package com.maantt.opf.entity;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer id;
	
	private String first_name;

	private String last_name;

	private String email;

	private String password;
	

	private String location;

	private Float rating;
	
	
    private Integer project_id;
    
    private Long contributeduser_id;
      
    @OneToMany(targetEntity=ContributedUserEntity.class,cascade=CascadeType.ALL)
	   @JoinColumn(name="user_id",referencedColumnName="id")
	    private List<ContributedUserEntity> contributeduserentity;

    public UserEntity() {
			}



	public UserEntity(Integer id, String first_name, String last_name, String email, String password, String location,
			Float rating) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.location = location;
		this.rating = rating;
	}



	public Long getContributeduser_id() {	
		return contributeduser_id;
	}
	



	public void setContributeduser_id(Long contributeduser_id) {
	this.contributeduser_id = contributeduser_id;
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



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public Float getRating() {
		return rating;
	}



	public void setRating(Float rating) {
		this.rating = rating;
	}



	public Integer getProject_id() {
		return project_id;
	}



	public void setProject_id(Integer project_id) {
		this.project_id = project_id;
	}



}
