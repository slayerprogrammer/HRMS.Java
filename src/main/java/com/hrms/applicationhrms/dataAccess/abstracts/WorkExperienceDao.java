package com.hrms.applicationhrms.dataAccess.abstracts;

import com.hrms.applicationhrms.entities.concretes.School;
import com.hrms.applicationhrms.entities.concretes.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkExperienceDao extends JpaRepository<WorkExperience,Integer> {

    @Query("Select w from Resume r join r.workExperiences w where r.jobSeeker.id=:jobSeekerId order by w.departureDate desc")
    List<WorkExperience> getByBusinessDate(int jobSeekerId);
}
