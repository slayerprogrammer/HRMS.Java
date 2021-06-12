package com.hrms.applicationhrms.business.abstracts;

import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.core.utilities.results.Result;
import com.hrms.applicationhrms.entities.concretes.Ability;
import com.hrms.applicationhrms.entities.concretes.ForeignLanguage;
import com.hrms.applicationhrms.entities.dtos.ForeignLanguageDto;

import java.util.List;

public interface ForeignLanguageService {

    Result add(List<ForeignLanguageDto> foreignLanguageDtos);
    DataResult<List<ForeignLanguage>> getAll(int jobSekerId);

}
