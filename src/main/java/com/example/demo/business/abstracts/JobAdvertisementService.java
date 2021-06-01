package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	Result add (JobAdvertisement jobAdvertisement);
	Result delete (JobAdvertisement jobAdvertisement);
	
	DataResult<List<JobAdvertisement>> findByIsActive(boolean isActive );
	DataResult<List<JobAdvertisement>> findByIsActiveOrderByDeadline(boolean isActive);
	DataResult<List<JobAdvertisement>> findByIsActiveAndEmployer_CompanyName(boolean isActive, String companyName);
	
	
}
