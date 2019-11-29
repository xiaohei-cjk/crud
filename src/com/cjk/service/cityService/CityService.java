package com.cjk.service.cityService;

import com.cjk.entity.City;

import java.util.List;

public interface CityService {

    /**
     * 查询所有省份
     * @return
     */
    public List<City> getAll();

    /**
     * 根据省份id查询所有所属城市
     * @param id
     * @return
     */
    public List<City> getAllById(Integer id);
}
