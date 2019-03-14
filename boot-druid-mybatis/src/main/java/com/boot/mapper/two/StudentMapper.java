package com.boot.mapper.two;

import com.boot.model.Student;

import java.util.List;

/**
 * Created by yezhiqin on 2018/6/29.
 */
public interface StudentMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> getList();

    int getCount();

    List<Student> selectStudentScore();
}
