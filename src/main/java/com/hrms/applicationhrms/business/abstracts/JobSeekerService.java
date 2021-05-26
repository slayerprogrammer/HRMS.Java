package com.hrms.applicationhrms.business.abstracts;

import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.entities.concretes.JobSeeker;

public interface JobSeekerService extends BaseService<JobSeeker> {

    DataResult<JobSeeker> getByIdentityNumber(String identityNumber);
    boolean isVerified();
}
