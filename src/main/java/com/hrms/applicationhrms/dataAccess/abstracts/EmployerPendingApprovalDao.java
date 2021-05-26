package com.hrms.applicationhrms.dataAccess.abstracts;

import com.hrms.applicationhrms.entities.concretes.EmployerPendingApproval;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerPendingApprovalDao extends JpaRepository<EmployerPendingApproval,Integer> {
}
