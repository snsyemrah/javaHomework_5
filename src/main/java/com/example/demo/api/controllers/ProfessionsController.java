package com.example.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.ProfessionService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entities.concretes.Profession;

@RestController
@RequestMapping("api/professions")

public class ProfessionsController {
	
	private ProfessionService professionService;
	@Autowired
	public ProfessionsController(ProfessionService professionService) {
		super();
		this.professionService = professionService;
	}
	@PostMapping("/add")
	public Result add(@RequestParam Profession profession) {
		return this.professionService.add(profession);
	}
	@GetMapping("/getall")
	public DataResult <List<Profession>> getAll(){
		return this.professionService.getAll();
	}
}
