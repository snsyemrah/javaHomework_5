package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entities.concretes.Experience;


public interface ExperienceService {
	Result add (Experience experience);
	DataResult<List<Experience>> getAll();
	DataResult<List<Experience>> getAllSoredByWorkStartDate();
}
