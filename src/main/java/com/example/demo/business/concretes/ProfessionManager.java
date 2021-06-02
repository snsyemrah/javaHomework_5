package com.example.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.ProfessionService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.core.utilities.results.SuccessDataResult;
import com.example.demo.core.utilities.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.ProfessionDao;
import com.example.demo.entities.concretes.Profession;

@Service
public class ProfessionManager implements ProfessionService{
	
	private ProfessionDao professionDao;
	@Autowired
	public ProfessionManager(ProfessionDao professionDao) {
		super();
		this.professionDao = professionDao;
	}

	@Override
	public Result add(Profession profession) {
		this.professionDao.save(profession);
		return new SuccessResult("Proglamlama ve teknoloji eklendi");
	}

	@Override
	public DataResult<List<Profession>> getAll() {
		return new SuccessDataResult<List<Profession>>
		(this.professionDao.findAll(), "Data listelendi");	
	}

}
