package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entities.concretes.JobPosition;

public interface JobPositionService {
	DataResult<List<JobPosition>> getAll();
	Result signUp(JobPosition jobPosition);
}
