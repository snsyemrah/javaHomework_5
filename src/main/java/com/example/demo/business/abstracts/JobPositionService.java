package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.entities.concretes.JobPosition;

public interface JobPositionService {
	List<JobPosition> getAll();
}
