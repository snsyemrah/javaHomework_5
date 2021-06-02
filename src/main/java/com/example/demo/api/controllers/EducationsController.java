package com.example.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.EducationService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entities.concretes.Education;

@RestController
@RequestMapping("/api/educations")

public class EducationsController {

		private EducationService educationService;
		@Autowired
		public EducationsController(EducationService educationService) {
			super();
			this.educationService = educationService;
		}
		
		@PostMapping("/add")
		public Result add(@RequestBody Education education) {
			return this.educationService.add(education);
		}
		
		
		@GetMapping("/getall")
		public DataResult<List<Education>> getAll(){
			return this.educationService.getAll();
		}
		
		
		@GetMapping("/getAllSortedByGraduationYear")
		public DataResult<List<Education>> getAllSortedByGraduationYear( ){
			return this.educationService.getAllSortedByGraduationYear();
		}
		
}
