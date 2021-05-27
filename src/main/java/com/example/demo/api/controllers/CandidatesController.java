package com.example.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.CandidateService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entities.concretes.Candidate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/candidates")


public class CandidatesController {
	
		private CandidateService candidateService;
	
		@Autowired
		public CandidatesController(CandidateService candidateService) {
			super();
			this.candidateService = candidateService;
		}
	
		@GetMapping("/getall")
		public DataResult<List<Candidate>> getAll(){
			return this.candidateService.getAll();
		}
	
		@PostMapping("/signup")
		public Result signUp(@RequestBody Candidate candidate) {
			return this.candidateService.signUp(candidate);
		}


	}
