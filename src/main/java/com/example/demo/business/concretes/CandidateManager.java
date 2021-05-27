package com.example.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.CandidateCheckService;
import com.example.demo.business.abstracts.CandidateService;
import com.example.demo.core.utilities.adapters.CheckIfRealPersonService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.ErrorResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.core.utilities.results.SuccessDataResult;
import com.example.demo.core.utilities.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.CandidateDao;
import com.example.demo.entities.concretes.Candidate;



@Service
public class CandidateManager implements CandidateService{
	
	private CandidateDao candidateDao;
	private CandidateCheckService candidateCheckService;
	private CheckIfRealPersonService checkIfRealPersonService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao,
			CandidateCheckService candidateCheckService,
			CheckIfRealPersonService checkIfRealPersonService) {
	super();
		this.candidateDao = candidateDao;
		this.candidateCheckService = candidateCheckService;
		this.checkIfRealPersonService = checkIfRealPersonService;
		
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll());
	}

	@Override
	public Result signUp(Candidate candidate) {
		if(!this.checkIfRealPersonService.checkIfRealPerson(candidate)) {
			return new ErrorResult("Gercek kisi degildir");
		}
		else if(!this.candidateCheckService.checkIfIdentityExist(candidate)) {
			return new ErrorResult("Mevcut Id");
		}
		else if(!this.candidateCheckService.checkIfMailExist(candidate)) {
			return new ErrorResult("Mevcut Email");
		}
		else if(!this.candidateCheckService.checkIfMailActivation()) {
			return new ErrorResult("Email aktif degil");
		}
		else
			return new SuccessResult("Kayit basarili");

	}
}