package com.hrms.applicationhrms.business.abstracts;

import com.hrms.applicationhrms.core.entities.concretes.User;
import com.hrms.applicationhrms.core.utilities.results.DataResult;


public interface UserService extends BaseService<User> {

    DataResult<User> getByEmail(String email);
}
