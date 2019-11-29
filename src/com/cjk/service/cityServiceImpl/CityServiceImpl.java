package com.cjk.service.cityServiceImpl;

import com.cjk.dao.CityDao;
import com.cjk.entity.City;
import com.cjk.service.cityService.CityService;

import java.util.List;

public class CityServiceImpl implements CityService{

    CityDao cityDao=new CityDao();

    @Override
    public List<City> getAll() {
        return cityDao.getAll();
    }

    @Override
    public List<City> getAllById(Integer id) {
        return cityDao.getAllById(id);
    }
}
