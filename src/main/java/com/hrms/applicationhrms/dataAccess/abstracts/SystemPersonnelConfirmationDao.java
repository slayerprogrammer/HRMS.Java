package com.hrms.applicationhrms.dataAccess.abstracts;

import com.hrms.applicationhrms.entities.concretes.SystemPersonnelConfirmation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemPersonnelConfirmationDao extends JpaRepository<SystemPersonnelConfirmation, Integer> {

}
