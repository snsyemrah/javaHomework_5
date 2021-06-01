package com.example.demo.core.utilities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.JobPositionCheckService;
import com.example.demo.business.abstracts.JobPositionService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.ErrorResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.core.utilities.results.SuccessDataResult;
import com.example.demo.core.utilities.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.JobPositionDao;
import com.example.demo.entities.concretes.JobPosition;
@Service // Bu class projede servis gorevi gorecek diye Spring'e bilgi veriyoruz!
public class JobPositionManager implements JobPositionService{

	
	private JobPositionDao jobPositionDao;
	private JobPositionCheckService jobPositionCheckService;
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao, JobPositionCheckService jopPositionCheckService) {
		super();
		this.jobPositionDao = jobPositionDao;
		this.jobPositionCheckService = jopPositionCheckService;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll());
	}

	@Override
	public Result signUp(JobPosition jobPosition) {
		if(!this.jobPositionCheckService.checkIfPositionExist(jobPosition)) {
			return new ErrorResult("Meslek mevcut");
		}else {
			this.jobPositionDao.save(jobPosition);
			return new SuccessResult("Meslek eklendi");
		}
	}

}
