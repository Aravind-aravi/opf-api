package com.maantt.opf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maantt.opf.entity.EmployeeEntity;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer> {

	 EmployeeEntity findByEmail(String email);
}
