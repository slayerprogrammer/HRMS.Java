package com.hrms.applicationhrms.api.controllers;

import com.hrms.applicationhrms.business.abstracts.HobbyService;
import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.entities.concretes.Hobby;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/hobbies")
public class HobbiesController {

    private HobbyService hobbyService;

    @Autowired
    public HobbiesController(HobbyService hobbyService) {
        this.hobbyService = hobbyService;
    }

    @GetMapping("/getall")
    public DataResult<List<Hobby>> getAll(){
        return this.hobbyService.getAll();
    }

}
