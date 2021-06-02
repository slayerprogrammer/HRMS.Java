package com.hrms.applicationhrms.dataAccess.abstracts;

import com.hrms.applicationhrms.entities.concretes.JobSeekerImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobSeekerImageDao extends JpaRepository<JobSeekerImage,Integer> {
    List<JobSeekerImage> getAllByJobSeekerId(int jobSeekerId);
}
