package com.mai.springbootlibraryms.service;

import cn.hutool.db.Page;
import com.github.pagehelper.PageInfo;
import com.mai.springbootlibraryms.controller.request.BaseRequest;
import com.mai.springbootlibraryms.controller.request.UserPageRequest;
import com.mai.springbootlibraryms.pojo.User;

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
