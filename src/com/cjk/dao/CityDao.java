package com.cjk.dao;

import com.cjk.entity.City;
import com.cjk.utils.JdbcTemplateUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CityDao {


    JdbcTemplate jdbcTemplate= new JdbcTemplate(JdbcTemplateUtil.getDataSource());


    /**
     * 查询所有省份
     * @return
     */
    public List<City> getAll(){
        String sql="select * from city_table where type=1";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(City.class));
    }

    /**
     * 根据省份id查询所有所属城市
     * @param id
     * @return
     */
    public List<City> getAllById(Integer id){
        String sql="select * from city_table where belong=?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(City.class),id);
    }
}
