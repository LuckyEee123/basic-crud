package com.mai.boot.controller;

import com.mai.boot.common.Result;
import com.mai.boot.controller.dto.LoginDTO;
import com.mai.boot.controller.request.AdminPageRequest;
import com.mai.boot.controller.request.LoginRequest;
import com.mai.boot.pojo.Admin;
import com.mai.boot.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping("/login")
    public Result login(@RequestBody LoginRequest loginRequest) {
        LoginDTO loginDTO = adminService.login(loginRequest);
        return Result.success(loginDTO);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Admin admin = adminService.getById(id);
        return Result.success(admin);
    }

    @RequestMapping("/save")
    public Result save(@RequestBody Admin admin) {
        adminService.save(admin);
        return Result.success();
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Admin admin) {
        adminService.update(admin);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        adminService.deleteById(id);
        return Result.success();
    }

    @RequestMapping("/findAll")
    public Result findAll() {
        List<Admin> users = adminService.findAll();
        return Result.success(users);
    }

    @RequestMapping("/page")
    public Result page(AdminPageRequest adminPageRequest) {
        return Result.success(adminService.page(adminPageRequest));
    }

}
