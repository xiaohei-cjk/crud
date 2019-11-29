package com.cjk.service.userServiceImpl;

import com.cjk.dao.UserDao;
import com.cjk.entity.User;
import com.cjk.service.userService.UserService;
import com.cjk.utils.PageBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao=new UserDao();

    public List<User> findAllUser(){
        return userDao.findAllUser();
    }

    @Override
    public PageBean<User> findAllUser(PageBean<User> pageBean, String account) {
        return userDao.findAllUser(pageBean,account);
    }

    @Override
    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }

    @Override
    public void addUser(User user) {
        //设置初始密码
        user.setPassword("123456");
        //设置用户创建时间
        Date now=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String string=simpleDateFormat.format(now);
        user.setCreateTime(string);

        userDao.addUser(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        userDao.deleteUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public Integer userCount(String account) {
        return userDao.userCount(account);
    }
}
