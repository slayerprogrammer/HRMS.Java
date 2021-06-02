package com.hrms.applicationhrms.dataAccess.abstracts;

import com.hrms.applicationhrms.entities.concretes.Resume;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ResumeDao extends JpaRepository<Resume,Integer> {

      Resume getByJobSeekerId(int jobSeekerId);
      Resume getByJobSeekerId(int jobSeekerId,Sort sort);


}
