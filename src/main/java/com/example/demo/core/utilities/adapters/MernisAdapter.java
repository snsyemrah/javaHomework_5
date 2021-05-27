package com.example.demo.core.utilities.adapters;

import org.springframework.stereotype.Service;

import com.example.demo.entities.concretes.Candidate;
@Service
public class MernisAdapter implements CheckIfRealPersonService {

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		if (candidate.getIdentityNumber().length() != 11) {
			return false;
		}
		return true;

	}
}
