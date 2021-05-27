package com.example.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.CandidateCheckService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.SuccessDataResult;
import com.example.demo.dataAccess.abstracts.CandidateDao;
import com.example.demo.entities.concretes.Candidate;
@Service
public class CandidateCheckManager implements CandidateCheckService{
	
	
	private CandidateDao candidateDao;
	
	@Autowired
	public CandidateCheckManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	@Override
	public boolean checkIfMailExist(Candidate candidate) {
		if(this.findByEmail(candidate.getEmail()).getData().size()!=0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	@Override
	public boolean checkIfIdentityExist(Candidate candidate) {
		
		if(this.findByIdentityNumber(candidate.getIdentityNumber()).getData().size()!=0) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean checkIfMailActivation() {
		
		return true;
	}

	@Override
	public DataResult<List<Candidate>> findByEmail(String email) {
		return new SuccessDataResult<List<Candidate>>
		(this.candidateDao.findByEmail(email));
	}

	@Override
	public DataResult<List<Candidate>> findByIdentityNumber(String identityNumber) {
		return new SuccessDataResult<List<Candidate>>
		(this.candidateDao.findByIdentityNumber(identityNumber));
	}

}
