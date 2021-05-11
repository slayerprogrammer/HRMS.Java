package com.hrms.tolga.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.tolga.entity.JobTitle;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer> {
	
}
