package com.maantt.opf.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.maantt.opf.entity.EmployeeEntity;
import com.maantt.opf.repository.EmployeeRepo;


@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo repo;
	
	@Autowired
	private BCryptPasswordEncoder password;
	
	
	public List<EmployeeEntity> fetchEmployeeEntityList()
	{
	return repo.findAll();	
	}

	public EmployeeEntity saveEmployeeEntityToDB(EmployeeEntity EmployeeEntity) 
	{
	String pass =EmployeeEntity.getPassword();
	String encrpt = password.encode(pass);
	EmployeeEntity.setPassword(encrpt);
	  return repo.save(EmployeeEntity);	
	}
	
	public EmployeeEntity updateEmployeeEntityToDB(EmployeeEntity EmployeeEntity) 
	{
	  return repo.save(EmployeeEntity);	
	}

	public Optional<EmployeeEntity> fetchEmployeeEntityById(int id) 
	{
	  return repo.findById(id);	
	}
	
	
	public EmployeeEntity fetchEmployeeEntityByEmail(String email)
	{
		return repo.findByEmail(email);
	}

	public String deleteEmployeeEntityById(int id) 
	{
		String result;
		
		try 
		{
			repo.deleteById(id);
			result="Data successfully deleted";
		} 
		
		catch (Exception e) {
			result="Data of the id is not deleted";
		}
		return result;
	  	
	}


}
