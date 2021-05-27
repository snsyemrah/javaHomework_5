
package com.example.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.JobPositionService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.entities.concretes.JobPosition;

@RestController // Sen controller'sin demek!
@RequestMapping("/api/job_positions")  // Dis dunyadan "/api/job_positions" diye bir istek gelirse bunu JobPositionsController kara verecektir! 
public class JobPositionsController {   //api'de isimler cogul verilir!

	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionsController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}

	@GetMapping("/getall")  // /api/jop_positions/getall diye bir istekte bulunursak JobPosition listelenir!!! 
	public DataResult<List<JobPosition>> getAll() {
		return this.jobPositionService.getAll();
	}
}