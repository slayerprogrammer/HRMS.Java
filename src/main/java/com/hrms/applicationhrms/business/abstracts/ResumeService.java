package com.hrms.applicationhrms.business.abstracts;

import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.core.utilities.results.Result;
import com.hrms.applicationhrms.entities.concretes.Resume;
import com.hrms.applicationhrms.entities.dtos.JobSeekerResumeDto;
import com.hrms.applicationhrms.entities.dtos.ResumeDto;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ResumeService {

    Result add(ResumeDto resumeDto);
    DataResult<List<Resume>> getAll();
    DataResult<Resume> getByJobSeekerForResume(int jobSeekerId);
    DataResult<Resume> getAllForInOrder(int jobSeekerId);


}
