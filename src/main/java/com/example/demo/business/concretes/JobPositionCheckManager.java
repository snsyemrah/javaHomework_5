package com.example.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.JobPositionCheckService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.SuccessDataResult;
import com.example.demo.dataAccess.abstracts.JobPositionDao;
import com.example.demo.entities.concretes.JobPosition;



@Service
public class JobPositionCheckManager implements JobPositionCheckService{

	private JobPositionDao jobPositionDao;
	
	@Autowired
	
	public JobPositionCheckManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}
	
	@Override
	public boolean checkIfPositionExist(JobPosition position) {
		if(this.findByPosition(position.getPosition()).getData().size()!=0) {
			return false;
		}else {
			return true;
		}
		
	}

	@Override
	public DataResult<List<JobPosition>> findByPosition(String position) {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findByJobPosition(position));
	}

}
