package com.boot.model;

import java.io.Serializable;

/**
 * 用于接收学生表和成绩表查询信息
 * Created by yezhiqin on 2018/6/14.
 */
public class StudentInfo {

//    String getName();
//    String getAge();
//    String getChineseScore();
//    String getMathScore();
//    String getEnglishScore();

    private String name;
    private Integer age;
    private Double chineseScore;
    private Double mathScore;
    private Double englishScore;

    public StudentInfo() {
    }

    public StudentInfo(String name, Integer age, Double chineseScore, Double mathScore, Double englishScore) {
        this.name = name;
        this.age = age;
        this.chineseScore = chineseScore;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getChineseScore() {
        return chineseScore;
    }

    public void setChineseScore(Double chineseScore) {
        this.chineseScore = chineseScore;
    }

    public Double getMathScore() {
        return mathScore;
    }

    public void setMathScore(Double mathScore) {
        this.mathScore = mathScore;
    }

    public Double getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(Double englishScore) {
        this.englishScore = englishScore;
    }
}
