package com.example.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer>{
	
	
}
