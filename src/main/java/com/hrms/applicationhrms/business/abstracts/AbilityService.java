package com.hrms.applicationhrms.business.abstracts;

import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.core.utilities.results.Result;
import com.hrms.applicationhrms.entities.concretes.Ability;
import com.hrms.applicationhrms.entities.dtos.AbilityDto;

import java.util.List;

public interface AbilityService {

    Result add(List<AbilityDto> abilityDto);
    DataResult<List<Ability>> getAll(int jobSekerId);

}
