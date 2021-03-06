package com.boot.controller;

import com.boot.entity.User;
import com.boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户controller
 * Created by yezhiqin on 2018/7/19.
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/setSession")
    public Map<String, Object> setSession (HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        request.getSession().setAttribute("mysession", request.getRequestURL());
        map.put("request Url", request.getRequestURL());
        return map;
    }

    @RequestMapping(value = "/getSession")
    public Object getSession (HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());
        map.put("message", request.getSession().getAttribute("mysession"));
        return map;
    }


    @RequestMapping(value = "/index")
    public String index (HttpServletRequest request){
        String msg="登录成功！！";
        Object user= request.getSession().getAttribute("user");
        if (user==null){
            msg="请登录！！";
        }
        return msg;
    }

    @RequestMapping(value = "/login")
    public String login (HttpServletRequest request,String userName,String password){
        String msg="登陆失败!";
        User user= userRepository.findByUserName(userName);
        if (user!=null && user.getPassword().equals(password)){
            request.getSession().setAttribute("user",user);
            msg="登陆成功！！";
        }
        return msg;
    }
}
