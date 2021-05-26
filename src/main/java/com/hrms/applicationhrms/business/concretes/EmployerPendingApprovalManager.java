package com.hrms.applicationhrms.business.concretes;

import com.hrms.applicationhrms.business.abstracts.EmployerPendingApprovalService;
import com.hrms.applicationhrms.business.constants.Messages;
import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.core.utilities.results.Result;
import com.hrms.applicationhrms.core.utilities.results.SuccessDataResult;
import com.hrms.applicationhrms.core.utilities.results.SuccessResult;
import com.hrms.applicationhrms.dataAccess.abstracts.EmployerPendingApprovalDao;
import com.hrms.applicationhrms.entities.concretes.Employer;
import com.hrms.applicationhrms.entities.concretes.EmployerPendingApproval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerPendingApprovalManager implements EmployerPendingApprovalService {

    private EmployerPendingApprovalDao pendingApprovalDao;

    @Autowired
    public EmployerPendingApprovalManager(EmployerPendingApprovalDao pendingApprovalDao) {
        this.pendingApprovalDao = pendingApprovalDao;
    }

    @Override
    public Result save(EmployerPendingApproval employerPendingApproval) {
        this.pendingApprovalDao.save(employerPendingApproval);
        return new SuccessResult();
    }

    @Override
    public DataResult<EmployerPendingApproval> getById(int id) {
        return new SuccessDataResult<EmployerPendingApproval>(this.pendingApprovalDao.findById(id).get());
    }

    @Override
    public DataResult<List<EmployerPendingApproval>> getAll() {
        return new SuccessDataResult<List<EmployerPendingApproval>>(this.pendingApprovalDao.findAll(), Messages.pendingApprovalListed());
    }

    @Override
    public Result delete(EmployerPendingApproval employerPendingApproval) {
        this.pendingApprovalDao.delete(employerPendingApproval);
        return new SuccessResult();
    }
}
