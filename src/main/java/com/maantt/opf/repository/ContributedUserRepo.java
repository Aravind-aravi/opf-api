package com.maantt.opf.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.maantt.opf.entity.ContributedUserEntity;
import com.maantt.opf.entity.UserEntity;
@Transactional
public interface ContributedUserRepo extends JpaRepository<ContributedUserEntity, Long>{


}
