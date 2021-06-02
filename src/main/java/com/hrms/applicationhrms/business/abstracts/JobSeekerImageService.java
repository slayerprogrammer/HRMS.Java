package com.hrms.applicationhrms.business.abstracts;

import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.core.utilities.results.Result;
import com.hrms.applicationhrms.entities.concretes.JobSeekerImage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface JobSeekerImageService {

    Result add(JobSeekerImage jobSeekerImage);
    Result addPhoto(JobSeekerImage jobSeekerImage, MultipartFile multipartFile);
    DataResult<List<JobSeekerImage>> getAll();
    DataResult<List<JobSeekerImage>> getAllByJobSeekerId(int jobSeekerId);

}
