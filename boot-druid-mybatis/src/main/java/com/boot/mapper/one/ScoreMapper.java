package com.boot.mapper.one;

import com.boot.model.Score;

import java.util.List;

/**
 * Created by yezhiqin on 2018/6/29.
 */
public interface ScoreMapper {

    int deleteByPrimaryKey(String id);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);

    List<Score> getListScore();
}
