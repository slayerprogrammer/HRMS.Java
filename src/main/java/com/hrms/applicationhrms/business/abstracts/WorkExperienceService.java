package com.hrms.applicationhrms.business.abstracts;

import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.core.utilities.results.Result;
import com.hrms.applicationhrms.entities.concretes.School;
import com.hrms.applicationhrms.entities.concretes.WorkExperience;
import com.hrms.applicationhrms.entities.dtos.WorkExperienceDto;

import java.util.List;

public interface WorkExperienceService {

    Result add (List<WorkExperienceDto> workExperienceDtos);
    DataResult<List<WorkExperience>> getByBusinessDate(int jobSeekerId);

}
