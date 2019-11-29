package com.cjk.dao;

import com.cjk.entity.User;
import com.cjk.utils.JdbcTemplateUtil;
import com.cjk.utils.PageBean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDao {

    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JdbcTemplateUtil.getDataSource());

    /**
     * 查询所有用户
     * @return
     */
    public List<User> findAllUser(){
        String sql="select * from user_table";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class));
    }


    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    public User findUserById(Integer id){
        String sql="select * from user_table where id=?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),id);
    }

    /**
     * 根据id删除用户
     * @param id
     */
    public void deleteUserById(Integer id){
        String sql="delete from user_table where id=?";
        jdbcTemplate.update(sql,id);
    }

    /**
     * 添加用户
     * @param user
     */
    public void addUser(User user){
        String sql="insert into user_table(account,password,name,age,sex,birthday,createTime) values (?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,user.getAccount(),user.getPassword(),user.getName(),user.getAge(),user.getSex(),user.getBirthday(),user.getCreateTime());
    }

    /**
     * 修改用户
     * @param user
     */
    public void updateUser(User user){
        String sql="update user_table set account=?,name=?,age=?,sex=?,birthday=? where id=?";
        jdbcTemplate.update(sql,user.getAccount(),user.getName(),user.getAge(),user.getSex(),user.getBirthday(),user.getId());
    }

    /**
     * 根据条件查询用户（分页）
     * @param pageBean
     * @param account
     * @return
     */
    public PageBean<User> findAllUser(PageBean<User> pageBean,String account){

        String sql="select * from user_table where account like ? limit ?,?";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class),"%"+account+"%",(pageBean.getPage()-1)*pageBean.getPageSize(),pageBean.getPageSize());
        pageBean.setList(userList);
        return pageBean;
    }

    /**
     * 根据条件查询用户总条数
     * @param account
     * @return
     */
    public Integer userCount(String account){
        String sql="select count(*) from user_table where account like ?";
        return jdbcTemplate.queryForObject(sql,Integer.class,"%"+account+"%");
    }

}
