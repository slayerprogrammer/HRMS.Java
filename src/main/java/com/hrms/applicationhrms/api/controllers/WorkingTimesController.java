package com.hrms.applicationhrms.api.controllers;

import com.hrms.applicationhrms.business.abstracts.WorkingTimeService;
import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.entities.concretes.WorkingTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/workingstime")
@CrossOrigin
public class WorkingTimesController {

    private WorkingTimeService workingTimeService;

    @Autowired
    public WorkingTimesController(WorkingTimeService workingTimeService) {
        this.workingTimeService = workingTimeService;
    }

    @GetMapping("/getall")
    public DataResult<List<WorkingTime>> getAll(){
        return this.workingTimeService.getAll();
    }

}
