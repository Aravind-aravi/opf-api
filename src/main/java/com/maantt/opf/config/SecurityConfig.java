package com.maantt.opf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.*;
//import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
//    @Bean
//	public AuthenticationProvider authProvider()
//	{
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setUserDetailsService(userDetailsService);
//		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//		return provider;
//	} 
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws
    Exception{
    	auth.userDetailsService(userDetailsService).passwordEncoder(encodePwd());
    }
    
    @Bean
    public BCryptPasswordEncoder encodePwd() {
    	return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
		.antMatchers(HttpMethod.OPTIONS,"/user/rest/**","/employee/rest/**")
		.permitAll().anyRequest().authenticated()
				.and().httpBasic();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
		.antMatchers(HttpMethod.POST,"/user/rest/adduserentitylist")
		.antMatchers(HttpMethod.PATCH,"/user/rest/updatestatus")
		.antMatchers(HttpMethod.PATCH,"/employee/rest/updateemployee")
		.antMatchers(HttpMethod.PATCH,"/user/rest/uploadfile")
		.antMatchers(HttpMethod.PATCH,"/user/rest/uploadproject")
		.antMatchers(HttpMethod.PATCH,"/user/rest/startproject")
		.antMatchers(HttpMethod.PATCH,"/user/rest/updateuser")
		.antMatchers(HttpMethod.PATCH,"/user/rest/projectupdate")
		.antMatchers(HttpMethod.GET,"/user/rest/getuserentitylist")

		.antMatchers(HttpMethod.GET,"/user/rest/getuserentitybyid/{id}")
		.antMatchers(HttpMethod.GET,"/employee/rest/getemployeeentitylist")
		.antMatchers(HttpMethod.DELETE,"/user/rest/deleteuserentitybyid/{id}")
		.antMatchers(HttpMethod.POST,"/employee/rest/addemployeeentitylist")
		.antMatchers(HttpMethod.GET,"/user/rest/getprojectentitybyid/{id}")
		.antMatchers(HttpMethod.GET,"/user/rest/getprojectentitylist")
		.antMatchers(HttpMethod.DELETE,"/user/rest/deleteprojectentitybyid/{id}")
		.antMatchers(HttpMethod.POST,"/user/rest/addprojectentitylist")
		.antMatchers(HttpMethod.GET,"/user/rest/api/file/all")
		.antMatchers(HttpMethod.GET,"/user/rest/api/file/{id}")
//		.antMatchers(HttpMethod.GET,"/employee/rest/getemployeeentitybyemail/{email}")	
		;
		}
    

    
    
} 