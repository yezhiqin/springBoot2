package com.boot.entity;


import javax.persistence.*;

/**
 * Created by zhoujh on 2018/7/20.
 */
@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String age;

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
        return age;
    }

    public void setWord(String word) {
        this.age = age;
    }
}
