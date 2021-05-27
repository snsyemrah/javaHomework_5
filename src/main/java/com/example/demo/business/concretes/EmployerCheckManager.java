package com.example.demo.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.EmployerCheckService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.SuccessDataResult;
import com.example.demo.dataAccess.abstracts.EmployerDao;
import com.example.demo.entities.concretes.Employer;


@Service
public class EmployerCheckManager implements EmployerCheckService{

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerCheckManager (EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public boolean checkIfMailExist(Employer employer) {
		if(this.findByEmail(employer.getEmail()).getData().size()!=0) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean checkMailActivation() {		
		return true;
	}

	@Override
    public boolean checkIfMailDomain(Employer employer) {
        String regex = "^[A-Za-z0-9._%+-]+@" + employer.getWebAddress() +"$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(employer.getEmail());
        if(matcher.matches()) {
            return true;
        }else {
            return false;
        }
	}

	@Override
	public DataResult<List<Employer>> findByEmail(String email) {
		return new SuccessDataResult<List<Employer>> (this.employerDao.findByEmail(email) , "Is verenler listelendi");
	}
	
	
}
