package com.mai.boot.service;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mai.boot.controller.dto.LoginDTO;
import com.mai.boot.controller.request.BaseRequest;
import com.mai.boot.controller.request.LoginRequest;
import com.mai.boot.exception.ServiceException;
import com.mai.boot.mapper.AdminMapper;
import com.mai.boot.pojo.Admin;
import com.mai.boot.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class AdminServiceImpl implements AdminService{

    private static final String PASSWORD_DEFAULT = "PASSWORD1";
    private static final String PASSWORD_SALT = "191RIFLE";

    @Autowired
    AdminMapper adminMapper;

    @Override
    public List<Admin> findAll() {
        return adminMapper.findAll();
    }

    @Override
    public PageInfo<Admin> page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<Admin> admins = adminMapper.listByCondition(baseRequest);
        return new PageInfo<>(admins);
    }

    @Override
    public LoginDTO login(LoginRequest loginRequest) {
        Admin admin = null;
        loginRequest.setPassword(securePwd(loginRequest.getPassword()));
        admin = adminMapper.login(loginRequest);
            if (admin == null) {
                throw new ServiceException("用户名或密码错误");
            }
            LoginDTO loginDTO = new LoginDTO();
        BeanUtils.copyProperties(admin, loginDTO);

            // 生成token
            String token = TokenUtils.genToken(String.valueOf(admin.getId()),admin.getPassword());
            loginDTO.setToken(token);
            return loginDTO;

    }

    @Override
    public void save(Admin admin) {
        if (StrUtil.isBlank(admin.getPassword())) {
            admin.setPassword(PASSWORD_DEFAULT);
        }
        // md5加密,加盐
        admin.setPassword(securePwd(admin.getPassword()));
        Date date = new Date();
        admin.setCreatetime(date);
        adminMapper.save(admin);
    }

    @Override
    public Admin getById(Integer id) {
        return adminMapper.getById(id);
    }

    @Override
    public void update(Admin admin) {
        admin.setUpdatetime(new Date());
        adminMapper.update(admin);
    }

    @Override
    public void deleteById(Integer id) {
        adminMapper.deleteById(id);
    }

    private String securePwd(String password) {
        return SecureUtil.md5(password + PASSWORD_SALT);
    }

}
