package com.hrms.applicationhrms.business.abstracts;

import com.hrms.applicationhrms.core.utilities.results.Result;
import com.hrms.applicationhrms.entities.concretes.Employer;
import com.hrms.applicationhrms.entities.concretes.EmployerPendingApproval;
import com.hrms.applicationhrms.entities.concretes.JobSeeker;

public interface EmployerService extends BaseService<Employer>{
    Result checkEmailConfirm(EmployerPendingApproval entity);
    boolean isVerified();
}
