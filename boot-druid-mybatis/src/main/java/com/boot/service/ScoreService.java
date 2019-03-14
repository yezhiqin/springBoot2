package com.boot.service;

import com.boot.mapper.one.ScoreMapper;
import com.boot.model.Score;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 学生成绩类service
 * Created by yezhiqin on 2018/6/25.
 */
@Service
public class ScoreService {

    @Resource
    private ScoreMapper scoreMapper;


    public List<Score> findStudentScore(){
        return scoreMapper.getListScore();
    }

    public Score findByKeyScore(String id){
        return scoreMapper.selectByPrimaryKey(id);
    }
}
