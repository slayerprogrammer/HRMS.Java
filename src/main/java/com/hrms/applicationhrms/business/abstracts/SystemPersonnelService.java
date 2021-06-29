package com.hrms.applicationhrms.business.abstracts;

import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.core.utilities.results.Result;
import com.hrms.applicationhrms.entities.concretes.Employer;
import com.hrms.applicationhrms.entities.concretes.EmployerProfileUpdate;
import com.hrms.applicationhrms.entities.concretes.SystemPersonnel;
import com.hrms.applicationhrms.entities.dtos.PostListDto;

import java.util.List;

public interface SystemPersonnelService {

    DataResult<List<SystemPersonnel>> getAll();
    DataResult<SystemPersonnel> getById(int id);
    DataResult<SystemPersonnel> add(SystemPersonnel systemPersonnel);
    DataResult<SystemPersonnel> update(SystemPersonnel systemPersonnel);
    DataResult<SystemPersonnel> delete(SystemPersonnel systemPersonnel);
    DataResult<Employer> activeEmployerRegistration(int employerId);
    DataResult<Employer> employerProfileUpdateAccept(int employerId);
    DataResult<EmployerProfileUpdate> employerProfileUpdateReject(int employerId);
    DataResult<Employer> rejectEmployerRegistration(int employerId);
    DataResult<Employer> passiveEmployerRegistration(int employerId);
    DataResult<PostListDto> activePost(int postId);
    DataResult<PostListDto> passivePost(int postId);
    DataResult<PostListDto> rejectPost(int postId);


}
