package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.entities.concretes.Candidate;

public interface CandidateCheckService {
	
	boolean checkIfMailExist(Candidate candidate);
	boolean checkIfIdentityExist(Candidate candidate);
	boolean checkIfMailActivation();
	
	DataResult<List<Candidate>>findByEmail(String email);
	DataResult<List<Candidate>>findByIdentityNumber(String identityNumber);
}
