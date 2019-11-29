package com.cjk.service.userService;

import com.cjk.entity.User;
import com.cjk.utils.PageBean;

import java.util.List;

public interface UserService {

    /**
     * 查询所有用户
     * @return
     */
    public List<User> findAllUser();

    /**
     * 根据条件查询用户
     * @param pageBean
     * @param account
     * @return
     */
    public PageBean<User> findAllUser(PageBean<User> pageBean,String account);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    public User findUserById(Integer id);

    /**
     * 添加用户
     * @param user
     */
    public void addUser(User user);

    /**
     * 根据用户id删除用户
     * @param id
     */
    public void deleteUserById(Integer id);

    /**
     * 修改用户
     * @param user
     */
    public void updateUser(User user);

    /**
     * 根据条件查询用户总条数
     * @param account
     * @return
     */
    public Integer userCount(String account);
}
