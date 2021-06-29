package com.hrms.applicationhrms.api.controllers;

import com.hrms.applicationhrms.business.abstracts.SectionService;
import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.entities.concretes.Faculity;
import com.hrms.applicationhrms.entities.concretes.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/sections")
public class SectionsController {

    private SectionService sectionService;

    @Autowired
    public SectionsController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @GetMapping("/getall")
    public DataResult<List<Section>> getAll(){
        return this.sectionService.getAll();
    }

    @GetMapping("/getByFaculity")
    public DataResult<List<Section>> getByFaculity(int uniId,int faculityId){
        return this.sectionService.getByFaculity(uniId,faculityId);
    }

}
