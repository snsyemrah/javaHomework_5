package com.example.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.JobAdvertisementService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.ErrorResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.core.utilities.results.SuccessDataResult;
import com.example.demo.core.utilities.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.JobAdvertisementDao;
import com.example.demo.entities.concretes.JobAdvertisement;
@Service
public class JobAdvertisementManager implements JobAdvertisementService{
	
	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisementDao.findByAdvertisementIdEquals(jobAdvertisement.getAdvertisementId())!=null) {
			return new ErrorResult("İş ilanı mevcut");
		}else {
			this.jobAdvertisementDao.save(jobAdvertisement);
			return new SuccessResult("İş ilanı eklendi");
		}
		
	}

	@Override
	public Result delete(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.delete(jobAdvertisement);
		return new SuccessResult("İş ilanı silindi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActive(boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findByIsActive(isActive));
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveOrderByDeadline(boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findByIsActiveOrderByDeadline(isActive));
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveAndEmployer_CompanyName(boolean isActive, String companyName) {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findByIsActiveAndEmployer_CompanyName(isActive, companyName));
	}

}
