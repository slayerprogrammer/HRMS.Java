package com.hrms.applicationhrms.business.abstracts;

import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.core.utilities.results.Result;
import com.hrms.applicationhrms.entities.concretes.Employer;
import com.hrms.applicationhrms.entities.concretes.EmployerProfileUpdate;

import java.util.List;

public interface EmployerService {
    DataResult<Employer> add(Employer employer);
    DataResult<Employer> updateProfile(EmployerProfileUpdate employerProfileUpdate);
    DataResult<Employer> update(Employer employer);
    DataResult<Employer> delete(Employer employer);
    DataResult<List<Employer>> getAll();
    DataResult<Employer> getById(int id);
    DataResult<List<Employer>> getAllUpdateProfile();
    DataResult<List<Employer>> getAllActives();
    DataResult<List<Employer>> getAllPassive();
    DataResult<List<Employer>> getAllWaitingApproval();
    DataResult<List<Employer>> getAllRejected();
    boolean isVerified();
    Result passivePost(int postId);

}
