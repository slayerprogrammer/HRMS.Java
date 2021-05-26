package com.hrms.applicationhrms.business.abstracts;

import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.core.utilities.results.Result;
import com.hrms.applicationhrms.entities.concretes.JobPosition;

import java.util.List;

public interface BaseService<T> {
    DataResult<List<T>> getAll();
    DataResult<T> getById(int id);
    Result add(T entity);
    Result update(T entity);
    Result delete(T entity);
}
