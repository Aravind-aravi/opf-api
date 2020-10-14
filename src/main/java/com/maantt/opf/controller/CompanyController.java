package com.maantt.opf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.maantt.opf.entity.CompanyEntity;
import com.maantt.opf.services.CompanyService;

@RestController
public class CompanyController {
@Autowired
private CompanyService service;

@CrossOrigin(origins = "http://localhost:4200")
@GetMapping("/getcompanyentitylist")
public List<CompanyEntity> fetchCompanyEntityList(){
	List<CompanyEntity> company= new ArrayList<CompanyEntity>();
	//logic to fetch list from database
	company = service.fetchCompanyEntityList();
	return company;
}
@CrossOrigin(origins = "http://localhost:4200")
@PostMapping("/addcompanyentitylist")
public CompanyEntity saveCompanyEntityList(@RequestBody CompanyEntity CompanyEntity){
	return service.saveCompanyEntityToDB(CompanyEntity);
}
@CrossOrigin(origins = "http://localhost:4200")
@GetMapping("/getcompanyentitybyid/{id}")
public CompanyEntity fetchCompanyEntityById(@PathVariable int id){
	return service.fetchCompanyEntityById(id).get();
}
@CrossOrigin(origins = "http://localhost:4200")
@DeleteMapping("/deletecompanyentitybyid/{id}")
public String DeleteCompanyEntityById(@PathVariable int id){
return service.deleteCompanyEntityById(id);	
}



}
