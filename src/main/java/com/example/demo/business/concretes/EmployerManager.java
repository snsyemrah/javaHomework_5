package com.example.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.EmployerCheckService;
import com.example.demo.business.abstracts.EmployerService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.ErrorResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.core.utilities.results.SuccessDataResult;
import com.example.demo.core.utilities.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.EmployerDao;
import com.example.demo.entities.concretes.Employer;
@Service
public class EmployerManager implements EmployerService{
	
	private EmployerCheckService employerCheckService;
	private EmployerDao employerDao;
	@Autowired
	public EmployerManager(EmployerDao employerDao,
			EmployerCheckService employerCheckService) {
		super();
		this.employerDao = employerDao;
		this.employerCheckService = employerCheckService;
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>
		(this.employerDao.findAll());
	}

	@Override
	public Result signUp(Employer employer) {
		if(!this.employerCheckService.checkIfMailExist(employer)) {
			return new ErrorResult("Bu mail adresi sistemde mevcut");
		}
		else if(this.employerCheckService.checkMailActivation()) {
			return new ErrorResult("Mail adresiniz aktif edilmemis");
		}
		
		else if(this.employerCheckService.checkIfMailDomain(employer)) {
			return new ErrorResult("Mail Domain gerekli");
		}
		else {
			this.employerDao.save(employer);
			return new SuccessResult("Is veren eklendi");
		}

	}
}
