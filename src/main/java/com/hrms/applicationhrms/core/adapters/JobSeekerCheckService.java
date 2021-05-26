package com.hrms.applicationhrms.core.adapters;

import com.hrms.applicationhrms.entities.dtos.JobSeekerForRegisterDto;

public interface JobSeekerCheckService {

    boolean checkIfRealPerson(JobSeekerForRegisterDto jobSeeker);

}
