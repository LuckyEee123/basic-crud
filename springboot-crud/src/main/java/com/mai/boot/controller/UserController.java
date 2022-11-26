package com.mai.boot.controller;

import com.mai.boot.common.Result;
import com.mai.boot.controller.request.UserPageRequest;
import com.mai.boot.pojo.User;
import com.mai.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        User user = userService.getById(id);
        return Result.success(user);
    }

    @RequestMapping("/save")
    public Result save(@RequestBody User user) {
        userService.save(user);
        return Result.success();
    }

    @RequestMapping("/update")
    public Result update(@RequestBody User user) {
        userService.update(user);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        userService.deleteById(id);
        return Result.success();
    }

    @RequestMapping("/findAll")
    public Result findAll() {
        List<User> users = userService.findAll();
        return Result.success(users);
    }

    @RequestMapping("/page")
    public Result page(UserPageRequest userPageRequest) {
        return Result.success(userService.page(userPageRequest));
    }

}
