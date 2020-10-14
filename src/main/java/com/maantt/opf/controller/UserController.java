package com.maantt.opf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maantt.opf.entity.EmployeeEntity;
import com.maantt.opf.entity.UserEntity;
import com.maantt.opf.repository.UserRepo;
import com.maantt.opf.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user/rest/")
public class UserController {
	@Autowired
	private UserService service;
	
	@Autowired
	private UserRepo Repo;
	

  @GetMapping("/getuserentitylist")
	public List<UserEntity> fetchUserEntityList(){
		List<UserEntity> user= new ArrayList<UserEntity>();
		//logic to fetch list from database
		user = service.fetchUserEntityList();
		return user;
	}
	
	@PostMapping("/adduserentitylist")
	public UserEntity saveUserEntityList(@RequestBody UserEntity UserEntity){
		return service.saveUserEntityToDB(UserEntity);
	}	
	
	@PatchMapping("/updateuserentitylist")
	public UserEntity updateUserEntityList(@RequestBody UserEntity UserEntity){
		return service.saveUserEntityToDB(UserEntity);
	}	


	@GetMapping("/getuserentitybyid/{id}")
	public UserEntity fetchUserEntityById(@PathVariable int id){
		return service.fetchUserEntityById(id).get();
	}


	@GetMapping("/getuserentitybyemail/{email}")
	public Integer fetchUserEntityByEmail(@PathVariable String email){
		
		return service.fetchUserEntityByEmail(email).getId();
		
	}
	

	
	@DeleteMapping("/deleteuserentitybyid/{id}")
	public String DeleteUserEntityById(@PathVariable int id){
	return service.deleteUserEntityById(id);	
	}
	

//    @PatchMapping("/startproject")
//	public EmployeeEntity updateemployee(@RequestBody EmployeeEntity employeeentity){
//		EmployeeEntity employee =Repo.findById(employeeentity.getId()).orElse(null);
//		employee.setEmail(employeeentity.getEmail());
//		employee.setFirst_name(employeeentity.getFirst_name());
//		employee.setLast_name(employeeentity.getLast_name());
//		return Repo.save(employee);	
//				}
    

    @PatchMapping("/startproject")
	public UserEntity startproject(@RequestBody UserEntity userentity){
		UserEntity user =Repo.findById(userentity.getId()).orElse(null);
		user.setProject_id(userentity.getProject_id());
		return Repo.save(user);	
		}


    @PatchMapping("/uploadproject")
	public UserEntity uploadproject(@RequestBody UserEntity userentity){
		UserEntity user =Repo.findById(userentity.getId()).orElse(null);
		user.setContributeduser_id(userentity.getContributeduser_id());
		return Repo.save(user);	
		}


	
    @PatchMapping("/updateuser")
	public UserEntity updateuser(@RequestBody UserEntity userentity){
		UserEntity user =Repo.findById(userentity.getId()).orElse(null);
		user.setEmail(userentity.getEmail());
		user.setFirst_name(userentity.getFirst_name());
		user.setLast_name(userentity.getLast_name());
		user.setLocation(userentity.getLocation());
		return Repo.save(user);	
				}
    
	

}
