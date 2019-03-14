package com.boot.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 成绩表
 * Created by yezhiqin on 2018/6/14.
 */
@Entity
public class Score implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GenericGenerator(name = "PKUUID", strategy = "uuid")
    @GeneratedValue(generator = "PKUUID")
    private String id;
    @Column(nullable = false)
    private Long sid;
    @Column(nullable = false)
    private Double chineseScore;
    @Column(nullable = false)
    private Double mathScore;
    @Column(nullable = false)
    private Double englishScore;

    public Score() {
    }

    public Score(Long sid, Double chineseScore, Double mathScore, Double englishScore) {
        this.sid = sid;
        this.chineseScore = chineseScore;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
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
