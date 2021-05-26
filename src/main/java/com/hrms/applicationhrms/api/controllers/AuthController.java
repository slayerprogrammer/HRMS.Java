package com.hrms.applicationhrms.api.controllers;

import com.hrms.applicationhrms.business.abstracts.AuthService;
import com.hrms.applicationhrms.entities.dtos.EmployerForRegisterDto;
import com.hrms.applicationhrms.entities.dtos.JobSeekerForRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/jobseekerforregister")
    public ResponseEntity jobSeekerForRegister(@RequestBody JobSeekerForRegisterDto jobSeekerForRegisterDto) {
        var result = authService.jobSeekerForRegister(jobSeekerForRegisterDto);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/employerforregister")
    public ResponseEntity employerForRegister(@RequestBody EmployerForRegisterDto employerForRegisterDto) {
        var result = authService.employerForRegister(employerForRegisterDto);
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }





}