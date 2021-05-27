package com.example.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entities.concretes.JobPosition;


public interface JobPositionDao extends JpaRepository<JobPosition, Integer>{
	//@Entity annatation'u ile suslenmis nesne(burda JobPosition)'nin PrimaryKey olan Integer'ini vermek zorundayiz.  
	
	List<JobPosition> findByJobPosition (String position);
}
