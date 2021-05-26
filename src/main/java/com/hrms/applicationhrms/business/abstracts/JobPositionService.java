package com.hrms.applicationhrms.business.abstracts;

import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.entities.concretes.JobPosition;

public interface JobPositionService extends BaseService<JobPosition> {

    DataResult<JobPosition> getByPositionName(String positionName);

}
