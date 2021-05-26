package com.hrms.applicationhrms.business.abstracts;

import com.hrms.applicationhrms.entities.dtos.EmployerForRegisterDto;
import com.hrms.applicationhrms.entities.dtos.JobSeekerForRegisterDto;
import com.hrms.applicationhrms.core.entities.concretes.User;
import com.hrms.applicationhrms.entities.dtos.UserForLoginDto;
import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.core.utilities.results.Result;

public interface AuthService {

    Result jobSeekerForRegister(JobSeekerForRegisterDto jobSeekerForRegisterDto);
    Result employerForRegister(EmployerForRegisterDto employerForRegisterDto);
    DataResult<User> login(UserForLoginDto userForLoginDto);
}
