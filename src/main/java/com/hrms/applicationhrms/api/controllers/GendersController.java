package com.hrms.applicationhrms.api.controllers;

import com.hrms.applicationhrms.business.abstracts.GenderService;
import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.entities.concretes.Gender;
import com.hrms.applicationhrms.entities.dtos.ForeignLanguageDto;
import com.hrms.applicationhrms.entities.dtos.GenderDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/genders")
public class GendersController {

    private GenderService genderService;
    private ModelMapper modelMapper;


    @Autowired
    public GendersController(GenderService genderService,ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.genderService = genderService;
    }

    @GetMapping("/getall")
    public DataResult<List<Gender>> getAll(){
        return this.genderService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody GenderDto genderDto) {
        var result = genderService.add(genderDto);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

}
