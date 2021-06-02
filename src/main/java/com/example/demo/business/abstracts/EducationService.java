package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entities.concretes.Education;

public interface EducationService {

	Result add(Education education);
	DataResult<List<Education>> getAll();
	DataResult<List<Education>> getAllSortedByGraduationYear();
}
