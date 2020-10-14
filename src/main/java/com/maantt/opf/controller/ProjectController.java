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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maantt.opf.entity.ProjectEntity;
import com.maantt.opf.entity.UserEntity;
import com.maantt.opf.repository.ProjectRepo;
import com.maantt.opf.services.ProjectService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/user/rest/")
public class ProjectController {
	
	@Autowired
	private ProjectService service;
	
	@Autowired
	private ProjectRepo Repo;
	
	@GetMapping("/getprojectentitylist")
	public List<ProjectEntity> fetchProjectEntityList(){
		List<ProjectEntity> project= new ArrayList<ProjectEntity>();
		//logic to fetch list from database
		project = service.fetchProjectEntityList();
		return project;
	}
	
	@GetMapping("/getprojectentitybyid/{id}")
	public ProjectEntity fetchProjectEntityById(@PathVariable int id){
		return service.fetchProjectEntityById(id).get();
	}
	
	@PostMapping("/addprojectentitylist")
	public ProjectEntity saveProjectEntityList(@RequestBody ProjectEntity ProjectEntity){
		System.out.println(ProjectEntity);
		return service.saveProjectEntityToDB(ProjectEntity);
	}
	
	@PutMapping("/updateprojectentitylist")
	public ProjectEntity updateProjectEntityList(@RequestBody ProjectEntity ProjectEntity){
		return service.saveProjectEntityToDB(ProjectEntity);
	}
	
	
	@DeleteMapping("/deleteprojectentitybyid/{id}")
	public String DeleteProjectEntityById(@PathVariable int id){
	return service.deleteProjectEntityById(id);	
	}


    @PatchMapping("/projectupdate")
	public ProjectEntity projectUpdate(@RequestBody ProjectEntity projectentity){
		ProjectEntity project =Repo.findById(projectentity.getId()).orElse(null);
		project.setHead_line(projectentity.getHead_line());
		project.setSummary(projectentity.getSummary());
		project.setSkill(projectentity.getSkill());
		return Repo.save(project);	
	}


}
