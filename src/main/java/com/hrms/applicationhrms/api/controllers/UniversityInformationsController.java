package com.hrms.applicationhrms.api.controllers;

import com.hrms.applicationhrms.business.abstracts.UniversityInformationService;
import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.entities.concretes.UniversityInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/universityInformations")
public class UniversityInformationsController {

    private UniversityInformationService universityInformationService;

    @Autowired
    public UniversityInformationsController(UniversityInformationService universityInformationService) {
        this.universityInformationService = universityInformationService;
    }

    @GetMapping("/getall")
    public DataResult<List<UniversityInformation>> getAll(){
        return this.universityInformationService.getAll();
    }


}
