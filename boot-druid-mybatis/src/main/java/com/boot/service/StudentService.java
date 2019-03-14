package com.boot.service;

import com.boot.mapper.two.StudentMapper;
import com.boot.model.Student;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 学生类service
 * Created by yezhiqin on 2018/6/25.
 */
@Service
public class StudentService {

    @Resource
    private StudentMapper studentMapper;


    /**
     * 新增学生
     * @param student
     * @return
     */
    public int addStudent(Student student){
        return this.studentMapper.insert(student);
    }


    /**
     * 删除学生
     * @param id
     * @return
     */
    public int deleteStudent(Long id){
        return this.studentMapper.deleteByPrimaryKey(id);
    }


    /**
     * 修改学生信息
     * @param student
     * @return
     */
    public int updateStudent(Student student){
        return this.studentMapper.updateByPrimaryKey(student);
    }

    /**
     * 查询学生信息
     * @param id
     * @return
     */
    public Student selectStudentById(Long id){
        return this.studentMapper.selectByPrimaryKey(id);
    }


    /**
     * 查询所有学生(分页)
     * @return
     */
    public PageInfo<Student> selectAllStudent(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Student> studentList = this.studentMapper.getList();
        PageInfo result = new PageInfo(studentList);
        return result;
    }

    /**
     * 查询所有学生成绩(分页)
     * @return
     */
    public PageInfo<Student> findAllStudentScore(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Student> studentList = this.studentMapper.selectStudentScore();
        PageInfo result = new PageInfo(studentList);
        return result;
    }


    /**
     * 查询所有学生总数(用于分页)
     * @return
     */
    public int selectStudentCount(){
        return this.studentMapper.getCount();
    }


    /**
     * 查询所有学生
     * @return
     */
    public List<Student> findAllStudent(){
        return this.studentMapper.getList();
    }
}
