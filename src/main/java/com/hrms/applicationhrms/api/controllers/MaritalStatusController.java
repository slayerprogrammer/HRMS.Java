package com.hrms.applicationhrms.api.controllers;

import com.hrms.applicationhrms.business.abstracts.MaritalStatusService;
import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.entities.concretes.Gender;
import com.hrms.applicationhrms.entities.concretes.MaritalStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/maritalStatus")
public class MaritalStatusController {

    private MaritalStatusService maritalStatusService;

    @Autowired
    public MaritalStatusController(MaritalStatusService maritalStatusService) {
        this.maritalStatusService = maritalStatusService;
    }

    @GetMapping("/getall")
    public DataResult<List<MaritalStatus>> getAll(){
        return this.maritalStatusService.getAll();
    }


}
