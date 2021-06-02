package com.hrms.applicationhrms.business.concretes;

import com.hrms.applicationhrms.business.abstracts.WorkExperienceService;
import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.core.utilities.results.Result;
import com.hrms.applicationhrms.core.utilities.results.SuccessDataResult;
import com.hrms.applicationhrms.core.utilities.results.SuccessResult;
import com.hrms.applicationhrms.dataAccess.abstracts.WorkExperienceDao;
import com.hrms.applicationhrms.entities.concretes.Resume;
import com.hrms.applicationhrms.entities.concretes.School;
import com.hrms.applicationhrms.entities.concretes.WorkExperience;
import com.hrms.applicationhrms.entities.dtos.SchoolDto;
import com.hrms.applicationhrms.entities.dtos.WorkExperienceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkExperienceManager implements WorkExperienceService {

    private WorkExperienceDao workExperienceDao;

    @Autowired
    public WorkExperienceManager(WorkExperienceDao workExperienceDao) {
        this.workExperienceDao = workExperienceDao;
    }


    @Override
    public Result add(List<WorkExperienceDto> workExperienceDtos) {
        List<WorkExperience> workExperiences = new ArrayList<WorkExperience>();
        for (WorkExperienceDto workExperienceDto : workExperienceDtos){
            var resume = new Resume();
            var workExperience = new WorkExperience();
            workExperience.setId(workExperienceDto.getId());
            workExperience.setDepartureDate(workExperienceDto.getDepartureDate());
            workExperience.setDateOfStart(workExperienceDto.getDateOfStart());
            workExperience.setJobPosition(workExperienceDto.getJobPosition());
            workExperience.setWorkPlaceName(workExperienceDto.getWorkPlaceName());
            resume.setId(workExperienceDto.getResumeId());
            workExperience.setResume(resume);
            workExperiences.add(workExperience);
        }
        this.workExperienceDao.saveAll(workExperiences);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<WorkExperience>> getByBusinessDate(int jobSeekerId) {
        return new SuccessDataResult<>(this.workExperienceDao.getByBusinessDate(jobSeekerId));
    }
}
