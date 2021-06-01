package com.example.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.JobAdvertisementService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("api/jobadvertisements")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	
	@PostMapping("/add")
	public Result add (@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@PostMapping("/delete")
	public Result delete (@RequestBody JobAdvertisement jobAdvertisement) { //@RequestBody extradan yaptim!!!!
		return this.jobAdvertisementService.delete(jobAdvertisement);
	}
	
	@GetMapping("/getByIsActive")
	public DataResult<List<JobAdvertisement>> findByIsActive(boolean isActive ){
		return this.jobAdvertisementService.findByIsActive(isActive);
	}
	
	
	@GetMapping("/getByIsActiveOrderByDeadline")
	public DataResult<List<JobAdvertisement>> findByIsActiveOrderByDeadline(boolean isActive){
		return this.jobAdvertisementService.findByIsActiveOrderByDeadline(isActive);
	}
	
	@GetMapping("/getByIsActiveByCompanyName")
	public DataResult<List<JobAdvertisement>> findByIsActiveAndEmployer_CompanyName(boolean isActive, @RequestParam String companyName){
		return this.jobAdvertisementService.findByIsActiveAndEmployer_CompanyName(isActive, companyName);
	}
}
