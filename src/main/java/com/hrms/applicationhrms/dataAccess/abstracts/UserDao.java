package com.hrms.applicationhrms.dataAccess.abstracts;

import com.hrms.applicationhrms.core.entities.concretes.User;
import com.hrms.applicationhrms.core.utilities.results.DataResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {

    User getByEmail(String email);

}
