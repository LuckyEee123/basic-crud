package com.mai.boot.service;

import com.github.pagehelper.PageInfo;
import com.mai.boot.controller.request.BaseRequest;
import com.mai.boot.pojo.User;

import java.util.List;


public interface UserService {

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 分页
     * @param baseRequest
     * @return
     */
    PageInfo<User> page(BaseRequest baseRequest);


    /**
     * 添加用户
     * @param user
     */
    void save(User user);

    User getById(Integer id);

    void update(User user);

    void deleteById(Integer id);
}
