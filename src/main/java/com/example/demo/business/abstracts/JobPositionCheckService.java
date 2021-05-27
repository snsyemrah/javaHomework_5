package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.entities.concretes.JobPosition;

public interface JobPositionCheckService {
	
	boolean checkIfPositionExist(JobPosition position);
	DataResult<List<JobPosition>> findByPosition(String position);
}