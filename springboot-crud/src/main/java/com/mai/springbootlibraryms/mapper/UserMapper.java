package com.mai.springbootlibraryms.mapper;

import com.mai.springbootlibraryms.controller.request.BaseRequest;
import com.mai.springbootlibraryms.controller.request.UserPageRequest;
import com.mai.springbootlibraryms.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 查询所有用户
     * @return
     */
    // @Select("select * from user")
    List<User> findAll();

    List<User> listByCondition(BaseRequest baseRequest);

    void save(User user);

    User getById(Integer id);

    void update(User user);

    void deleteById(Integer id);
}
