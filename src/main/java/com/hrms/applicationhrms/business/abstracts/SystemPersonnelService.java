package com.hrms.applicationhrms.business.abstracts;

import com.hrms.applicationhrms.core.utilities.results.Result;
import com.hrms.applicationhrms.entities.concretes.SystemPersonnel;

public interface SystemPersonnelService extends BaseService<SystemPersonnel>{
    Result confirmEmployerRegistration(int employerId,int personnelId);
    Result rejectEmployerRegistration(int employerId);
    Result activePost(int postId);
    Result passivePost(int postId);
    Result rejectPost(int postId);


}
