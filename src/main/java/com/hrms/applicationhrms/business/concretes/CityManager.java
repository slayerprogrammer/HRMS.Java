package com.hrms.applicationhrms.business.concretes;

import com.hrms.applicationhrms.business.abstracts.CityService;
import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.core.utilities.results.Result;
import com.hrms.applicationhrms.core.utilities.results.SuccessDataResult;
import com.hrms.applicationhrms.dataAccess.abstracts.CityDao;
import com.hrms.applicationhrms.entities.concretes.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {

    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    private CityDao cityDao;

    @Override
    public DataResult<List<City>> getAll() {
        var result = this.cityDao.findAll();
        result.remove(0);
        return new SuccessDataResult<>(result);
    }

    @Override
    public DataResult<City> getById(int id) {
        return new SuccessDataResult<City>(this.cityDao.findById(id).get());
    }

    @Override
    public Result add(City entity) {
        return null;
    }

    @Override
    public Result update(City entity) {
        return null;
    }

    @Override
    public Result delete(City entity) {
        return null;
    }
}
