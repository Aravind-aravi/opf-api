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

import com.maantt.opf.entity.ContributedUserEntity;
import com.maantt.opf.entity.EmployeeEntity;
import com.maantt.opf.entity.UserEntity;
import com.maantt.opf.repository.EmployeeRepo;
import com.maantt.opf.services.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/employee/rest/")
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@Autowired
	private EmployeeRepo Repo;
	
	@GetMapping("/getemployeeentitylist")
	public List<EmployeeEntity> fetchEmployeeEntityList(){
		List<EmployeeEntity> employee= new ArrayList<EmployeeEntity>();
		//logic to fetch list from database
		employee = service.fetchEmployeeEntityList();
		return employee;
	}
	
	@PostMapping("/addemployeeentitylist")
	public EmployeeEntity saveEmployeeEntityList(@RequestBody EmployeeEntity EmployeeEntity){
		return service.saveEmployeeEntityToDB(EmployeeEntity);
	}
	
	@PatchMapping("/updateemployeeentitylist")
	public EmployeeEntity updateEmployeeEntityList(@RequestBody EmployeeEntity EmployeeEntity){
		return service.saveEmployeeEntityToDB(EmployeeEntity);
	}
	
	@GetMapping("/getemployeeentitybyid/{id}")
	public EmployeeEntity fetchEmployeeEntityById(@PathVariable int id){
		return service.fetchEmployeeEntityById(id).get();
	}
	
    @GetMapping(produces = "application/json")
	@RequestMapping("/getemployeeentitybyemail/{email}")
	public Integer fetchEmployeeEntityByEmail(@PathVariable String email){
		System.out.println("fetchEmployeeEntityByEmail" +email);
		return service.fetchEmployeeEntityByEmail(email).getId();
		
	}
	
		
    @PatchMapping("/updateemployee")
	public EmployeeEntity updateemployee(@RequestBody EmployeeEntity employeeentity){
		EmployeeEntity employee =Repo.findById(employeeentity.getId()).orElse(null);
		employee.setEmail(employeeentity.getEmail());
		employee.setFirst_name(employeeentity.getFirst_name());
		employee.setLast_name(employeeentity.getLast_name());
		return Repo.save(employee);	
				}
    
    
    
    
    
	@DeleteMapping("/deleteemployeeentitybyid/{id}")
	public String DeleteEmployeeEntityById(@PathVariable int id){
	return service.deleteEmployeeEntityById(id);	
	}
	


}
