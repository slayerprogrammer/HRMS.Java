package com.hrms.applicationhrms.business.concretes;

import com.hrms.applicationhrms.business.abstracts.JobPositionService;
import com.hrms.applicationhrms.business.constants.Messages;
import com.hrms.applicationhrms.core.utilities.business.BusinessRules;
import com.hrms.applicationhrms.core.utilities.results.*;
import com.hrms.applicationhrms.dataAccess.abstracts.JobPositionDao;
import com.hrms.applicationhrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        super();
        this.jobPositionDao = jobPositionDao;
    }


    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),Messages.positionListed());
    }

    @Override
    public DataResult<JobPosition> getById(int id) {
        return null;
    }

    @Override
    public Result add(JobPosition jobPosition) {
        var result = BusinessRules.run(positionNameExists(jobPosition.getPositionName()));

        if(result != null){
            return result;
        }

        this.jobPositionDao.save(jobPosition);
        return new SuccessResult(Messages.jobPositionAdded(jobPosition.getPositionName()));
    }

    @Override
    public Result update(JobPosition jobPosition) {
        this.jobPositionDao.save(jobPosition);
        return new SuccessResult("Pozisyon güncellendi");
    }

    @Override
    public Result delete(JobPosition jobPosition) {
        this.jobPositionDao.delete(jobPosition);
        return new SuccessResult("Pozisyon silindi");
    }

    @Override
    public DataResult<JobPosition> getByPositionName(String positionName) {
        return new SuccessDataResult<JobPosition>(this.jobPositionDao.getByPositionName(positionName));
    }

    public Result positionNameExists(String positionName){
        var result = getByPositionName(positionName);
        if(result.getData() != null) {
            return new ErrorResult(Messages.positionNameIsAlreadyAvailable());
        }
        return new SuccessResult();
    }
}
