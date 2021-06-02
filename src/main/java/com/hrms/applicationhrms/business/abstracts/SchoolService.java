package com.hrms.applicationhrms.business.abstracts;

import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.core.utilities.results.Result;
import com.hrms.applicationhrms.entities.concretes.School;
import com.hrms.applicationhrms.entities.dtos.SchoolDto;

import java.util.List;

public interface SchoolService {

    Result add(List<SchoolDto> schools);
    DataResult<List<School>> getAllByJobSeekerOrderByDateOfGraduation(int jobSeekerId);

}
