package com.hrms.applicationhrms.business.concretes;

import com.hrms.applicationhrms.business.abstracts.SystemPersonnelConfirmationService;
import com.hrms.applicationhrms.core.utilities.results.Result;
import com.hrms.applicationhrms.core.utilities.results.SuccessResult;
import com.hrms.applicationhrms.dataAccess.abstracts.SystemPersonnelConfirmationDao;
import com.hrms.applicationhrms.entities.concretes.SystemPersonnelConfirmation;
import org.springframework.stereotype.Service;

@Service
public class SystemPersonnelConfirmationManager implements SystemPersonnelConfirmationService {

    private SystemPersonnelConfirmationDao systemPersonnelConfirmationDao;

    public SystemPersonnelConfirmationManager(SystemPersonnelConfirmationDao systemPersonnelConfirmationDao) {
        this.systemPersonnelConfirmationDao = systemPersonnelConfirmationDao;
    }

    @Override
    public Result add(SystemPersonnelConfirmation systemPersonnelConfirmation) {
        this.systemPersonnelConfirmationDao.save(systemPersonnelConfirmation);
        return new SuccessResult();
    }
}
