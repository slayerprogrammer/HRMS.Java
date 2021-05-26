package com.hrms.applicationhrms.dataAccess.abstracts;

import com.hrms.applicationhrms.entities.concretes.SystemPersonnel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemPersonnelDao extends JpaRepository<SystemPersonnel, Integer> {

}
