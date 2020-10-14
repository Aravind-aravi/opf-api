package com.maantt.opf.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@DynamicUpdate
@Table(name="contributed_user")

public class ContributedUserEntity {
	 @Id
	  @GeneratedValue
	    @Column(name = "id")
	  @JsonView(View.FileInfo.class)
	    private Long id;
	  
	    @Column(name = "name")
	    @JsonView(View.FileInfo.class)
	  private String name;
	    
	    @Column(name = "mimetype")
	  private String mimetype;
	  
	  @Lob
	    @Column(name="pic")
	    private byte[] pic;
	  
	  @Column(name = "approved_status")
        private String approved_status;
	  
	  
	  private Integer project_id;
	  
	  
       private Integer user_id;
 
	    @OneToMany(targetEntity=UserEntity.class,cascade=CascadeType.ALL)
	   @JoinColumn(name="contributeduser_id",referencedColumnName="id")
	    private List<UserEntity> userentity;

	
	public ContributedUserEntity() {
	}
	

	public ContributedUserEntity(String name, String mimetype, byte[] pic) {
		super();
		this.name = name;
		this.mimetype = mimetype;
		this.pic = pic;
	}


	public ContributedUserEntity(Long id, String name, String mimetype, byte[] pic, String approved_status,
			Integer project_id, Integer user_id, List<UserEntity> userentity) {
		super();
		this.id = id;
		this.name = name;
		this.mimetype = mimetype;
		this.pic = pic;
		this.approved_status = approved_status;
		this.project_id = project_id;
		this.user_id = user_id;
		this.userentity = userentity;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMimetype() {
		return mimetype;
	}


	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}


	public byte[] getPic() {
		return pic;
	}


	public void setPic(byte[] pic) {
		this.pic = pic;
	}


	public String getApproved_status() {
		return approved_status;
	}


	public void setApproved_status(String approved_status) {
		this.approved_status = approved_status;
	}


	public Integer getProject_id() {
		return project_id;
	}


	public void setProject_id(Integer project_id) {
		this.project_id = project_id;
	}


	public Integer getUser_id() {
		return user_id;
	}


	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}


	public List<UserEntity> getUserentity() {
		return userentity;
	}


	public void setUserentity(List<UserEntity> userentity) {
		this.userentity = userentity;
	}


			
}