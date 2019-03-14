package com.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by yezhiqin on 2018/7/20.
 */
@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue
    @ApiModelProperty(value = "用户id")
    private Integer id;

    @Column(length = 50)
    @ApiModelProperty(value = "用户名")
    private String name;

    @Column(length = 50)
    @ApiModelProperty(value = "用户密码")
    private String word;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
