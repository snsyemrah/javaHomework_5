package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.entities.concretes.Employer;

public interface EmployerCheckService {
	boolean checkIfMailExist(Employer employer);
	boolean checkMailActivation();
	boolean checkIfMailDomain(Employer employer);
	DataResult<List<Employer>> findByEmail(String email);
}
