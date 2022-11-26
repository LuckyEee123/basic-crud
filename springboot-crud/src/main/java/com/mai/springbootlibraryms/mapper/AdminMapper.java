package com.mai.springbootlibraryms.mapper;

import com.mai.springbootlibraryms.controller.request.BaseRequest;
import com.mai.springbootlibraryms.controller.request.LoginRequest;
import com.mai.springbootlibraryms.pojo.Admin;
import com.mai.springbootlibraryms.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {

    /**
     * 查询所有管理员
     * @return
     */
    // @Select("select * from user")
    List<Admin> findAll();

    List<Admin> listByCondition(BaseRequest baseRequest);

    void save(Admin admin);

    Admin getById(Integer id);

    void update(Admin admin);

    void deleteById(Integer id);

    Admin login(LoginRequest loginRequest);
}
