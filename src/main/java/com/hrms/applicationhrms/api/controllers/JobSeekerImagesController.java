package com.hrms.applicationhrms.api.controllers;

import com.hrms.applicationhrms.business.abstracts.JobSeekerImageService;
import com.hrms.applicationhrms.entities.concretes.JobSeeker;
import com.hrms.applicationhrms.entities.concretes.JobSeekerImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/jobseekerimages")
public class JobSeekerImagesController {

    private JobSeekerImageService imageService;

    @Autowired
    public JobSeekerImagesController(JobSeekerImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody MultipartFile file, @RequestParam int jobSeekerId){

        JobSeekerImage jobSeekerImage = new JobSeekerImage();
        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.setId(jobSeekerId);
        jobSeekerImage.setJobSeeker(jobSeeker);
        return ResponseEntity.ok(this.imageService.addPhoto(jobSeekerImage,file));
    }

    @GetMapping("/getall")
    public ResponseEntity getAll(){
        return ResponseEntity.ok(this.imageService.getAll());
    }
}
