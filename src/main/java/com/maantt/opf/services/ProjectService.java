package com.maantt.opf.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.maantt.opf.entity.ProjectEntity;
import com.maantt.opf.repository.ProjectRepo;

@Service

public class ProjectService {
	@Autowired
	private ProjectRepo repo;
	
	
	public ProjectEntity saveProjectEntityToDB(ProjectEntity ProjectEntity) 
	{
	  return repo.save(ProjectEntity);	
	}
	
	public ProjectEntity updateProjectEntityToDB(ProjectEntity ProjectEntity) 
	{
	  return repo.save(ProjectEntity);	
	}
	
	
	
	
	public List<ProjectEntity> fetchProjectEntityList()
	{
	return repo.findAll();	
	}

	public Optional<ProjectEntity> fetchProjectEntityById(int id) 
	{
	  return repo.findById(id);	
	}
	

	public String deleteProjectEntityById(int id) 
	{
		String result;
		
		try 
		{
			repo.deleteById(id);
			result="Data successfully deleted"+id;
		} 
		
		catch (Exception e) {
			result="Data of the id is not deleted"+id;
		}
		return result;
	  	
	}


	
	
	
	
	
	

}
