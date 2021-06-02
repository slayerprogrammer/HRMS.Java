package com.hrms.applicationhrms.business.concretes;

import com.hrms.applicationhrms.business.abstracts.AbilityService;
import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.core.utilities.results.Result;
import com.hrms.applicationhrms.core.utilities.results.SuccessDataResult;
import com.hrms.applicationhrms.core.utilities.results.SuccessResult;
import com.hrms.applicationhrms.dataAccess.abstracts.AbilityDao;
import com.hrms.applicationhrms.entities.concretes.Ability;
import com.hrms.applicationhrms.entities.concretes.Resume;
import com.hrms.applicationhrms.entities.concretes.School;
import com.hrms.applicationhrms.entities.dtos.AbilityDto;
import com.hrms.applicationhrms.entities.dtos.SchoolDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AbilityManager implements AbilityService {

    private AbilityDao abilityDao;

    @Autowired
    public AbilityManager(AbilityDao abilityDao) {
        this.abilityDao = abilityDao;
    }


    @Override
    public Result add(List<AbilityDto> abilityDtos) {
        List<Ability> abilities = new ArrayList<Ability>();
        for (AbilityDto abilityDto : abilityDtos){
            var resume = new Resume();
            var ability = new Ability();
            ability.setId(abilityDto.getId());
            ability.setAbilityName(abilityDto.getAbilityName());
            ability.setTechnologyName(abilityDto.getTechnologyName());
            resume.setId(abilityDto.getResumeId());
            ability.setResume(resume);
            abilities.add(ability);
        }
        this.abilityDao.saveAll(abilities);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<Ability>> getAll(int jobSekerId) {
        return new SuccessDataResult<>(this.abilityDao.getAll(jobSekerId));
    }
}
