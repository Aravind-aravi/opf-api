package com.maantt.opf.config.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.maantt.opf.entity.UserEntity;
import com.maantt.opf.repository.UserRepo;
@Primary
@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepo Repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	System.out.println(email);
	System.out.println("user");
	
	UserEntity user =Repo.findByEmail(email);
	System.out.println(user);
	
	UserPrincipal userdetails=null;
	 if(user!=null)
	 {
		 userdetails=new UserPrincipal(user);
		 userdetails.setUser(user);
		 System.out.println(user);
			
		 
	 }else {
		 System.out.println("user2");
			
		 throw new UsernameNotFoundException("user 404");
	 }
	 System.out.println("user3");
		
		return userdetails;
	}

}
