package com.hrms.applicationhrms.business.abstracts;

import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.core.utilities.results.Result;
import com.hrms.applicationhrms.entities.concretes.EmployerPendingApproval;

import java.util.List;

public interface EmployerPendingApprovalService {

    Result save(EmployerPendingApproval employerPendingApproval);
    DataResult<EmployerPendingApproval> getById(int id);
    DataResult<List<EmployerPendingApproval>> getAll();
    Result delete(EmployerPendingApproval employerPendingApproval);

}
