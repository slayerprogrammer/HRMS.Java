package com.hrms.applicationhrms.api.controllers;

import com.hrms.applicationhrms.business.abstracts.UniversityService;
import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.entities.concretes.HighSchool;
import com.hrms.applicationhrms.entities.concretes.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/universities")
public class UniversitiesController {

    private UniversityService universityService;

    @Autowired
    public UniversitiesController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping("/getall")
    public DataResult<List<University>> getAll(){
        return this.universityService.getAll();
    }


}
