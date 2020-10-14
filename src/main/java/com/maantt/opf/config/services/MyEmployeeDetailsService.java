package com.maantt.opf.config.services;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.maantt.opf.entity.EmployeeEntity;

import com.maantt.opf.repository.EmployeeRepo;

@Service

public class MyEmployeeDetailsService implements UserDetailsService {
	@Autowired
	private EmployeeRepo Repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		System.out.println("error");
		System.out.println("loadUsloadUserByUsername");
		EmployeeEntity employee =Repo.findByEmail(email);
		EmployeePrincipal userdetails=null;
		 if(employee!=null)
		 {
			 userdetails=new EmployeePrincipal(employee);
			 userdetails.setEmployee(employee);
			 System.out.println("employee");
		 }else {
			 System.out.println("employee");
			 throw new UsernameNotFoundException("user 404");
			 
		 }
			
			return userdetails;
		}
	}


