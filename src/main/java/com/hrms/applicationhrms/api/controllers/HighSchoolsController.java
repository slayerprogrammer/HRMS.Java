package com.hrms.applicationhrms.api.controllers;

import com.hrms.applicationhrms.business.abstracts.HighSchoolService;
import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.entities.concretes.Gender;
import com.hrms.applicationhrms.entities.concretes.HighSchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/highScholls")
public class HighSchoolsController {

    private HighSchoolService highSchoolService;

    @Autowired
    public HighSchoolsController(HighSchoolService highSchoolService) {
        this.highSchoolService = highSchoolService;
    }

    @GetMapping("/getall")
    public DataResult<List<HighSchool>> getAll(){
        return this.highSchoolService.getAll();
    }

}
