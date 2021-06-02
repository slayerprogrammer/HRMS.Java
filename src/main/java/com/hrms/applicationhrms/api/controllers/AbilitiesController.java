package com.hrms.applicationhrms.api.controllers;

import com.hrms.applicationhrms.business.abstracts.AbilityService;
import com.hrms.applicationhrms.entities.dtos.AbilityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/abilities")
public class AbilitiesController {

    private AbilityService abilityService;

    @Autowired
    public AbilitiesController(AbilityService abilityService) {
        this.abilityService = abilityService;
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll(int jobSeekerId){
        var result = abilityService.getAll(jobSeekerId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody List<AbilityDto> abilityDtos) {
        var result = abilityService.add(abilityDtos);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

}
