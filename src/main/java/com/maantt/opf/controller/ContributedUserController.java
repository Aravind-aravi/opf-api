package com.maantt.opf.controller;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonView;
import com.maantt.opf.entity.*;
import com.maantt.opf.repository.ContributedUserRepo;
import com.maantt.opf.services.ContributedUserService;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user/rest/")
public class ContributedUserController {
	@Autowired
	ContributedUserRepo Repo;
	
//	@Autowired
//	ContributedUserService service;
//	
	  @PostMapping("/api/file/upload")
	    public String uploadMultipartFile(@RequestParam("file") MultipartFile file) {
	      try {
	        // save file to PostgreSQL
	        ContributedUserEntity filemode = new ContributedUserEntity( file.getOriginalFilename(), file.getContentType(), file.getBytes());
	        Repo.save(filemode);
	        return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
	    } catch (  Exception e) {
	      return "FAIL! Maybe You had uploaded the file before or the file's size > 500MB";
	    }    
	      
	      
	    }
	  

		@PatchMapping("/uploadfile")
		public ContributedUserEntity file(@RequestBody ContributedUserEntity contributeduserentity){
			ContributedUserEntity contributeduser =Repo.findById(contributeduserentity.getId()).orElse(null);
			contributeduser.setProject_id(contributeduserentity.getProject_id());
            contributeduser.setUser_id(contributeduserentity.getUser_id());
            contributeduser.setApproved_status(contributeduserentity.getApproved_status());
			return Repo.save(contributeduser);	
					}
	   	  

		   
		@PatchMapping("/updatestatus")
		public ContributedUserEntity updatestatus(@RequestBody ContributedUserEntity contributeduserentity){
			ContributedUserEntity contributeduser =Repo.findById(contributeduserentity.getId()).orElse(null);
			contributeduser.setApproved_status(contributeduserentity.getApproved_status());
			return Repo.save(contributeduser);	
					}
	   
	  
	  
	  
	   @JsonView(View.FileInfo.class)
	   @GetMapping("/api/file/all")
	   public List<ContributedUserEntity> getListFiles() {
	     return Repo.findAll();
	   }
	   
	   @GetMapping("/api/file/{id}")
	   public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
	     Optional<ContributedUserEntity> fileOptional = Repo.findById(id);
	     
	     if(fileOptional.isPresent()) {
	       ContributedUserEntity file = fileOptional.get();
	       return ResponseEntity.ok()
	           .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
	           .body(file.getPic());  
	     }
	     
	     return ResponseEntity.status(404).body(null);
	   }
	   
	   //	
//	@CrossOrigin(origins = "http://localhost:4200")
//	@GetMapping("/getcontributeduserentitylist")
//	public List<ContributedUserEntity> fetchContributedUserEntityList(){
//		List<ContributedUserEntity> user= new ArrayList<ContributedUserEntity>();
//		//logic to fetch list from database
//		user = Repo.fetchContributedUserEntityList();
//		return user;
//	}
//	
	
//	@CrossOrigin(origins = "http://localhost:4200")
//	@GetMapping("/getcontributeduserentitybyid/{id}")
//	public ContributedUserEntity fetchContributedUserEntityById(@PathVariable long id){
//		return service.fetchContributedUserEntityById(id).get();
//	}

	

//	@CrossOrigin(origins = "http://localhost:4200")
//	@DeleteMapping("/deletecontributeduserentitybyid/{id}")
//	public String DeleteContributedUserEntityById(@PathVariable long id){
//	return service.deleteContributedUserEntityById(id);	
//	}
//	
//	

}
