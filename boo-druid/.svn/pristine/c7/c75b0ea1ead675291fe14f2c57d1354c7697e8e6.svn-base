package com.boot.controller;


import com.boot.entity.User;
import com.boot.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zhoujh on 2018/7/20.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping(value = "/all")
    public List<User> findAllUser() {
        return userDao.findAll();
    }

    @GetMapping("/find/{id}")
    public User findOneUser(Integer id) {
        return userDao.getOne(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(Integer id) {
        userDao.deleteById(id);
    }

    @PostMapping("/add")
    public void addStudentRestful(User user) {
        userDao.save(user);
    }

    @PutMapping("/update")
    public void updateUser(User user) {
        userDao.save(user);
    }
}
