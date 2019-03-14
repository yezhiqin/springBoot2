package com.boot.model;

import java.io.Serializable;

/**
 * @Description: 成绩类
 * @Author: yezhiqin
 * @CreateDate: 2018/6/20$ 下午9:27$
 * @Version: 1.0
 */
public class Score implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private Long sid;
    private Double chineseScore;
    private Double mathScore;
    private Double englishScore;

    public Score() {
    }

    public Score(String id, Long sid, Double chineseScore, Double mathScore, Double englishScore) {
        this.id = id;
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
