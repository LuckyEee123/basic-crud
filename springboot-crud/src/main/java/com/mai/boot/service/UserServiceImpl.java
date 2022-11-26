package com.mai.boot.service;

import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mai.boot.controller.request.BaseRequest;
import com.mai.boot.mapper.UserMapper;
import com.mai.boot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> findAll() {

        return userMapper.findAll();

    }

    @Override
    public PageInfo<User> page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<User> users = userMapper.listByCondition(baseRequest);
        return new PageInfo<>(users);
    }

    @Override
    public void save(User user) {
        Date date = new Date();
        // 当做卡号来处理
        user.setUsername(String.valueOf(Math.abs(IdUtil.fastSimpleUUID().hashCode())));
        user.setCreatetime(new Date());
        userMapper.save(user);
    }

    @Override
    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    @Override
    public void update(User user) {
        user.setUpdatetime(new Date());
        userMapper.update(user);
    }

    @Override
    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }
}
