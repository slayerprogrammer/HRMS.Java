package com.hrms.applicationhrms.api.controllers;

import com.hrms.applicationhrms.business.abstracts.WayOfWorkingService;
import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.entities.concretes.City;
import com.hrms.applicationhrms.entities.concretes.WayOfWorking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/waysofworking")
@CrossOrigin
public class WaysOfWorkingController {

    private WayOfWorkingService wayOfWorkingService;

    @Autowired
    public WaysOfWorkingController(WayOfWorkingService wayOfWorkingService) {
        this.wayOfWorkingService = wayOfWorkingService;
    }

    @GetMapping("/getall")
    public DataResult<List<WayOfWorking>> getAll(){
        return this.wayOfWorkingService.getAll();
    }


}
