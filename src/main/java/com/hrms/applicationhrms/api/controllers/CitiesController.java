package com.hrms.applicationhrms.api.controllers;

import com.hrms.applicationhrms.business.abstracts.CityService;
import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.entities.concretes.City;
import com.hrms.applicationhrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CitiesController {

    private CityService cityService;

    @Autowired
    public CitiesController(CityService cityService){
        this.cityService = cityService;
    }


    @GetMapping("/getall")
    public DataResult<List<City>> getAll(){
        return this.cityService.getAll();
    }


}
