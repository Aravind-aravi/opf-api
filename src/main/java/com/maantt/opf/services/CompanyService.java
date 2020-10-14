package com.maantt.opf.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maantt.opf.entity.CompanyEntity;
import com.maantt.opf.repository.CompanyRepo;
@Service
public class CompanyService {

	@Autowired
	private CompanyRepo repo;
	
	public List<CompanyEntity> fetchCompanyEntityList()
	{
	return repo.findAll();	
	}

	public CompanyEntity saveCompanyEntityToDB(CompanyEntity CompanyEntity) 
	{
	  return repo.save(CompanyEntity);	
	}

	public Optional<CompanyEntity> fetchCompanyEntityById(int id) 
	{
	  return repo.findById(id);	
	}

	public String deleteCompanyEntityById(int id) 
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
