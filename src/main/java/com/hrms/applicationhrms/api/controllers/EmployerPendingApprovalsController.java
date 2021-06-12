package com.hrms.applicationhrms.api.controllers;

import com.hrms.applicationhrms.business.abstracts.EmployerPendingApprovalService;
import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.entities.concretes.EmployerPendingApproval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employerpendingapprovals")
public class EmployerPendingApprovalsController {

    private EmployerPendingApprovalService employerPendingApprovalService;

    @Autowired
    public EmployerPendingApprovalsController(EmployerPendingApprovalService employerPendingApprovalService) {
        this.employerPendingApprovalService = employerPendingApprovalService;
    }

    @GetMapping("/getall")
    public DataResult<List<EmployerPendingApproval>> getAll(){
        return this.employerPendingApprovalService.getAll();
    }
}
