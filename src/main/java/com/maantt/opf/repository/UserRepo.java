package com.maantt.opf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maantt.opf.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer>{

 UserEntity findByEmail(String email);
}
