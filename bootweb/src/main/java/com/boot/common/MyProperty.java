package com.boot.common;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 自定义读取配置文件
 * Created by zhoujh on 2018/06/11
 */

@Component
public class MyProperty {

    @Value("${com.boot.name}")
    private String name;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
