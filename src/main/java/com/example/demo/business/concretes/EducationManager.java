package com.example.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.EducationService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.core.utilities.results.SuccessDataResult;
import com.example.demo.core.utilities.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.EducationDao;
import com.example.demo.entities.concretes.Education;

@Service
public class EducationManager implements EducationService{
	
	
	private EducationDao educationDao;
	@Autowired
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public Result add(Education education) {
		this.educationDao.save(education);
		return new SuccessResult("Egitim eklendi");
	}

	@Override
	public DataResult<List<Education>> getAll() {
		return new SuccessDataResult<List<Education>>
		(this.educationDao.findAll(), "Data listelendi");
	}

	@Override
	public DataResult<List<Education>> getAllSortedByGraduationYear() {
		Sort sort = Sort.by(Sort.Direction.DESC , "graduationYear");
		return new SuccessDataResult<List<Education>>
		(this.educationDao.findAll(sort), "Data eklendi");
	}

	

}
