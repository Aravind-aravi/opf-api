package com.maantt.opf.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.maantt.opf.entity.UserEntity;
import com.maantt.opf.repository.UserRepo;


@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;
	
	@Autowired
	private BCryptPasswordEncoder password;
	
	public List<UserEntity> fetchUserEntityList()
	{
	return repo.findAll();	
	}

	public UserEntity saveUserEntityToDB(UserEntity UserEntity) 
	{
		String pass =UserEntity.getPassword();
		String encrpt = password.encode(pass);
		UserEntity.setPassword(encrpt);
	  return repo.save(UserEntity);	
	}

	public UserEntity updateUserEntityToDB(UserEntity UserEntity) 
	{
			  return repo.save(UserEntity);	
	}

	public Optional<UserEntity> fetchUserEntityById(int id) 
	{
		
	  return repo.findById(id);	
	}

	public UserEntity fetchUserEntityByEmail(String email)
	{
		return repo.findByEmail(email);
	}
	
	public String deleteUserEntityById(int id) 
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
