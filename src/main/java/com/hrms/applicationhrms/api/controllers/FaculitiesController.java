package com.hrms.applicationhrms.api.controllers;

import com.hrms.applicationhrms.business.abstracts.FaculityService;
import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.entities.concretes.Faculity;
import com.hrms.applicationhrms.entities.concretes.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/faculities")
public class FaculitiesController {

    private FaculityService faculityService;

    @Autowired
    public FaculitiesController(FaculityService faculityService) {
        this.faculityService = faculityService;
    }

    @GetMapping("/getall")
    public DataResult<List<Faculity>> getAll(){
        return this.faculityService.getAll();
    }

    @GetMapping("/getByUniversity")
    public DataResult<List<Faculity>> getByUniversity(int id){
        return this.faculityService.getByUniversity(id);
    }


}
