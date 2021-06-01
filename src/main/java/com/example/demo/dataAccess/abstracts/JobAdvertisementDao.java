package com.example.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	
	JobAdvertisement findByAdvertisementIdEquals(int id);
	
	List<JobAdvertisement> findByIsActive(boolean isActive );
	List<JobAdvertisement> findByIsActiveOrderByDeadline(boolean isActive);
	List<JobAdvertisement> findByIsActiveAndEmployer_CompanyName(boolean isActive, String companyName);
}
