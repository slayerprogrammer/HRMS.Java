package com.hrms.applicationhrms.api.controllers;

import com.hrms.applicationhrms.business.abstracts.MilitaryStatusService;
import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.entities.concretes.Gender;
import com.hrms.applicationhrms.entities.concretes.MilitaryStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/militaryStatus")
public class MilitaryStatusController {

    private MilitaryStatusService militaryStatusService;

    @Autowired
    public MilitaryStatusController(MilitaryStatusService militaryStatusService) {
        this.militaryStatusService = militaryStatusService;
    }

    @GetMapping("/getall")
    public DataResult<List<MilitaryStatus>> getAll(){
        return this.militaryStatusService.getAll();
    }

}
