package com.maantt.opf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maantt.opf.entity.ContributedUserEntity;
import com.maantt.opf.repository.ContributedUserRepo;

@Service
public class ContributedUserService {

	@Autowired
	private ContributedUserRepo repo;
	
	public ContributedUserEntity updatestatus(ContributedUserEntity contributeduserentity) {
		ContributedUserEntity contributeduser =repo.findById(contributeduserentity.getId()).orElse(null);
		contributeduserentity.setApproved_status(contributeduserentity.getApproved_status());
		return repo.save(contributeduser);	
	}
	
	
}
