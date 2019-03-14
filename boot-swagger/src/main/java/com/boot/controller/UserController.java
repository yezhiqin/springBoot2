package com.boot.controller;


import java.util.List;

import com.boot.entity.User;
import com.boot.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by yezhiqin on 2018/7/20.
 */

@RestController
@RequestMapping("/user")
@EnableSwagger2 // 让swagger生成接口文档
public class UserController {

    @Autowired
    private UserDao userDao;

    @ApiOperation(value = "查找所有用户")
    @GetMapping(value = "/all")
    public List<User> findAllUser() {
        return userDao.findAll();
    }

    @ApiOperation(value = "查找一个用户")
    @GetMapping("/find/{id}")
    public User findOneUser(@ApiParam(value = "用户id") @PathVariable("id") Integer id) {
        return userDao.getOne(id);
    }

    @ApiOperation(value = "删除一个用户")
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@ApiParam(value = "用户id") @PathVariable("id") Integer id) {
        userDao.deleteById(id);
    }

    @ApiOperation(value = "新增一个用户")
    @PostMapping("/add")
    public void addStudentRestful(@ApiParam(value = "用户或用户各个属性") User user) {
        userDao.save(user);
    }

    @ApiOperation(value = "更新一个用户")
    @PutMapping("/update")
    public void updateUser(@ApiParam(value = "用户或用户各个属性") User user) {
        userDao.save(user);
    }
}
