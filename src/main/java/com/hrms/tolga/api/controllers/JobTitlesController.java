package com.hrms.tolga.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.tolga.business.abstracts.JobTitleService;
import com.hrms.tolga.entity.JobTitle;

@RestController
@RequestMapping("api/job-titles/")
public class JobTitlesController {
	
	private final JobTitleService jobTitleService;

	@Autowired
	public JobTitlesController(JobTitleService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
	}
	
	@GetMapping("getall")
	public List<JobTitle> getAll(){
		return jobTitleService.getAll();
	}
	
}
