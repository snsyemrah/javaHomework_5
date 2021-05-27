package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entities.concretes.Candidate;

public interface CandidateService {
	DataResult<List<Candidate>>getAll();
	Result signUp(Candidate candidate);
}
