package com.mai.springbootlibraryms.service;

import com.github.pagehelper.PageInfo;
import com.mai.springbootlibraryms.controller.dto.LoginDTO;
import com.mai.springbootlibraryms.controller.request.BaseRequest;
import com.mai.springbootlibraryms.controller.request.LoginRequest;
import com.mai.springbootlibraryms.pojo.Admin;

import java.util.List;


public interface AdminService {

    /**
     * 查询所有管理员
     * @return
     */
    List<Admin> findAll();

    /**
     * 分页
     * @param baseRequest
     * @return
     */
    PageInfo<Admin> page(BaseRequest baseRequest);


    /**
     * 添加管理员
     * @param admin
     */
    void save(Admin admin);

    Admin getById(Integer id);

    void update(Admin admin);

    void deleteById(Integer id);

    LoginDTO login(LoginRequest loginRequest);
}
