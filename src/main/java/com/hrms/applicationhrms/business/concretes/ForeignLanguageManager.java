package com.hrms.applicationhrms.business.concretes;

import com.hrms.applicationhrms.business.abstracts.ForeignLanguageService;
import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.core.utilities.results.Result;
import com.hrms.applicationhrms.core.utilities.results.SuccessDataResult;
import com.hrms.applicationhrms.core.utilities.results.SuccessResult;
import com.hrms.applicationhrms.dataAccess.abstracts.ForeignLanguageDao;
import com.hrms.applicationhrms.entities.concretes.ForeignLanguage;
import com.hrms.applicationhrms.entities.concretes.Resume;
import com.hrms.applicationhrms.entities.concretes.WorkExperience;
import com.hrms.applicationhrms.entities.dtos.ForeignLanguageDto;
import com.hrms.applicationhrms.entities.dtos.WorkExperienceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ForeignLanguageManager implements ForeignLanguageService {

    private ForeignLanguageDao foreignLanguageDao;

    @Autowired
    public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao) {
        this.foreignLanguageDao = foreignLanguageDao;
    }

    @Override
    public Result add(List<ForeignLanguageDto> foreignLanguageDtos) {
        List<ForeignLanguage> foreignLanguages = new ArrayList<ForeignLanguage>();
        for (ForeignLanguageDto foreignLanguageDto : foreignLanguageDtos){
            var resume = new Resume();
            var foreignLanguage = new ForeignLanguage();
            foreignLanguage.setId(foreignLanguageDto.getId());
            foreignLanguage.setLanguageName(foreignLanguageDto.getLanguageName());
            foreignLanguage.setLanguagelevel(foreignLanguageDto.getLanguagelevel());
            resume.setId(foreignLanguageDto.getResumeId());
            foreignLanguage.setResume(resume);
            foreignLanguages.add(foreignLanguage);
        }
        this.foreignLanguageDao.saveAll(foreignLanguages);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<ForeignLanguage>> getAll(int jobSekerId) {
        return new SuccessDataResult<>(this.foreignLanguageDao.getAll(jobSekerId));
    }
}
