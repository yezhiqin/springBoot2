package com.boot.controller;

import com.boot.common.MyProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 读取自定义property配置文件
 */

@RestController
public class ReadPropertyController {

    @Resource
    private MyProperty myProperty;


    @RequestMapping("/ready")
    public String showProperty(){

        return myProperty.getName();
    }
}
