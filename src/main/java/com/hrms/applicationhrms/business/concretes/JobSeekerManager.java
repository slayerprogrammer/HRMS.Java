package com.hrms.applicationhrms.business.concretes;

import com.hrms.applicationhrms.business.abstracts.JobSeekerService;
import com.hrms.applicationhrms.business.abstracts.UserService;
import com.hrms.applicationhrms.business.constants.Messages;
import com.hrms.applicationhrms.core.utilities.helpers.EmailService;
import com.hrms.applicationhrms.core.utilities.results.*;
import com.hrms.applicationhrms.dataAccess.abstracts.JobSeekerDao;
import com.hrms.applicationhrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;
    private EmailService emailService;
    private UserService userService;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao,EmailService emailService,UserService userService){
        this.jobSeekerDao = jobSeekerDao;
        this.emailService = emailService;
        this.userService = userService;
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),Messages.jobSeekersListed());
    }

    @Override
    public DataResult<JobSeeker> getById(int id) {
        return null;
    }

    @Override
    public Result add(JobSeeker entity) {
        this.emailService.send(entity.getEmail(),"Doğrulama Kodu", UUID.randomUUID().toString());
        if (!this.isVerified()){
            return new ErrorResult();
        }
        entity.setDateOfRegistration(Date.valueOf(LocalDate.now()));
        this.jobSeekerDao.save(entity);
        return new SuccessResult();
    }

    @Override
    public Result update(JobSeeker entity) {
        return null;
    }

    @Override
    public boolean isVerified() {
        return true;
    }

    @Override
    public Result delete(JobSeeker entity) {
        return null;
    }

    @Override
    public DataResult<JobSeeker> getByIdentityNumber(String identityNumber) {
        return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getByIdentityNumber(identityNumber));
    }
}
