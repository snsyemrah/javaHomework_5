package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entities.concretes.Language;

public interface LanguageService {
	Result add (Language language);
	DataResult<List<Language>> getAll();
}
