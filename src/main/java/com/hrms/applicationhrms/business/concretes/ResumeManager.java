package com.hrms.applicationhrms.business.concretes;

import com.hrms.applicationhrms.business.abstracts.*;
import com.hrms.applicationhrms.business.constants.Messages;
import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.core.utilities.results.Result;
import com.hrms.applicationhrms.core.utilities.results.SuccessDataResult;
import com.hrms.applicationhrms.core.utilities.results.SuccessResult;
import com.hrms.applicationhrms.dataAccess.abstracts.ResumeDao;
import com.hrms.applicationhrms.entities.concretes.JobSeeker;
import com.hrms.applicationhrms.entities.concretes.Resume;
import com.hrms.applicationhrms.entities.dtos.JobSeekerResumeDto;
import com.hrms.applicationhrms.entities.dtos.ResumeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeManager implements ResumeService {

    private ResumeDao resumeDao;
    private JobSeekerService jobSeekerService;
    private SchoolService schoolService;
    private ForeignLanguageService foreignLanguageService;
    private AbilityService abilityService;
    private WorkExperienceService workExperienceService;

    @Autowired
    public ResumeManager(ResumeDao resumeDao,JobSeekerService jobSeekerService,
                         SchoolService schoolService,ForeignLanguageService foreignLanguageService,
                         AbilityService abilityService,WorkExperienceService workExperienceService) {
        this.resumeDao = resumeDao;
        this.jobSeekerService=jobSeekerService;
        this.schoolService = schoolService;
        this.foreignLanguageService = foreignLanguageService;
        this.abilityService = abilityService;
        this.workExperienceService = workExperienceService;
    }

    @Override
    public Result add(ResumeDto resumeDto) {
        var jobSeeker = new JobSeeker();
        jobSeeker.setId(resumeDto.getJobSeekerId());
        var resume = new Resume();
        resume.setId(resume.getId());
        resume.setJobSeeker(jobSeeker);
        resume.setDescription(resumeDto.getDescription());
        resume.setGithubAddress(resumeDto.getGithubAddress());
        resume.setLinkedinAddress(resumeDto.getLinkedinAddress());
        this.resumeDao.save(resume);
        return new SuccessResult(Messages.resumeCreated());
    }

    @Override
    public DataResult<List<Resume>> getAll() {
        return new SuccessDataResult<>(this.resumeDao.findAll());
    }

    @Override
    public DataResult<Resume> getByJobSeekerForResume(int jobSeekerId) {
        return new SuccessDataResult<Resume>(this.resumeDao.getByJobSeekerId(jobSeekerId));
    }

    @Override
    public DataResult<Resume> getAllForInOrder(int jobSeekerId) {
        var result = this.resumeDao.getByJobSeekerId(jobSeekerId);
        result.setAbilities(this.abilityService.getAll(jobSeekerId).getData());
        result.setForeignLanguages(this.foreignLanguageService.getAll(jobSeekerId).getData());
        result.setWorkExperiences(this.workExperienceService.getByBusinessDate(jobSeekerId).getData());
        result.setSchools(this.schoolService.getAllByJobSeekerOrderByDateOfGraduation(jobSeekerId).getData());
        return new SuccessDataResult<>(result);
    }
}
