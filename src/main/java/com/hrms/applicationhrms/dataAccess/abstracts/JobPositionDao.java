package com.hrms.applicationhrms.dataAccess.abstracts;

import com.hrms.applicationhrms.entities.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer> {

    JobPosition getByPositionName(String positionName);

}
