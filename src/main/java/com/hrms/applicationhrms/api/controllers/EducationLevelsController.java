package com.hrms.applicationhrms.api.controllers;

import com.hrms.applicationhrms.business.abstracts.EducationLevelService;
import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.entities.concretes.EducationLevel;
import com.hrms.applicationhrms.entities.concretes.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/educationLevels")
public class EducationLevelsController {

    private EducationLevelService educationLevelService;

    @Autowired
    public EducationLevelsController(EducationLevelService educationLevelService) {
        this.educationLevelService = educationLevelService;
    }

    @GetMapping("/getall")
    public DataResult<List<EducationLevel>> getAll(){
        return this.educationLevelService.getAll();
    }


}
