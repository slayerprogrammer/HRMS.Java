package com.hrms.applicationhrms.business.concretes;

import com.hrms.applicationhrms.business.abstracts.SchoolService;
import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.core.utilities.results.Result;
import com.hrms.applicationhrms.core.utilities.results.SuccessDataResult;
import com.hrms.applicationhrms.core.utilities.results.SuccessResult;
import com.hrms.applicationhrms.dataAccess.abstracts.SchoolDao;
import com.hrms.applicationhrms.entities.concretes.Resume;
import com.hrms.applicationhrms.entities.concretes.School;
import com.hrms.applicationhrms.entities.dtos.SchoolDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolManager implements SchoolService {

    private SchoolDao schoolDao;

    @Autowired
    public SchoolManager(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    @Override
    public Result add(List<SchoolDto> schoolDtos) {
        List<School> schools = new ArrayList<School>();
        for (SchoolDto schoolDto : schoolDtos){
            var resume = new Resume();
            var school = new School();
            school.setId(schoolDto.getId());
            school.setSchoolName(schoolDto.getSchoolName());
            school.setDateOfGraduation(schoolDto.getDateOfGraduation());
            school.setStartingDate(schoolDto.getStartingDate());
            school.setSectionName(schoolDto.getSectionName());
            resume.setId(schoolDto.getResumeId());
            school.setResume(resume);
            schools.add(school);
        }
        this.schoolDao.saveAll(schools);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<School>> getAllByJobSeekerOrderByDateOfGraduation(int jobSeekerId) {
        return new SuccessDataResult<>(this.schoolDao.findByOrderByDateOfGraduationDesc(jobSeekerId));
    }


}
