package com.hrms.tolga.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.tolga.business.abstracts.JobTitleService;
import com.hrms.tolga.dataAccess.abstracts.JobTitleDao;
import com.hrms.tolga.entity.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {

	private JobTitleDao jobTitleDao;
	
	
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}



	@Override
	public List<JobTitle> getAll() {
		return this.jobTitleDao.findAll();
	}

}
