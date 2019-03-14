package com.boot.controller;

import com.boot.model.Score;
import com.boot.model.Student;
import com.boot.model.StudentInfo;
import com.boot.service.StudentScoreService;
import com.boot.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 测试学生CRUD和两表联查
 */
@RestController
public class StudentController {

    @Resource
    private StudentService studentService;

    @Resource
    private StudentScoreService studentScoreService;




    @RequestMapping("/crud")
    public String studentCRUD() {

        StringBuffer sb = new StringBuffer();

        studentService.save(new Student("zhangsans", 18,"aabb@126.com", "北京"));
        studentService.save(new Student("lisis", 22,"lissi@126.com", "天津"));
        studentService.save(new Student("wangwuw", 19,"wangwuw@126.com", "河北"));

        //查询所有
        System.out.println("总共有学生人数:"+studentService.findAll().size());

        List<Student> studentList =  studentService.findAll();
        sb.append("新增的学生姓名：");
        for (Student stu :studentList){
            sb.append(stu.getName()+"\n");
        }


        //根据姓名和邮箱查询
        Student student = studentService.findByNameOrAddress("zhangsans", "aabb@126.com");


        String stuName = student.getName();

        System.out.println("根据姓名和邮箱查询到到学生是:"+student.getName());
        sb.append("根据姓名和邮箱查询到到学生是:"+student.getName()+"\n");


        student.setName("zhangsansan");

        student.setName("zhangsansan");
        Student newStu = studentService.save(student);
        sb.append("修改"+stuName+"后姓名是:"+newStu.getName());

        //删除一个学生
        studentService.delete(studentService.findByname("wangwuw"));
        System.out.println("删除一个学生后总共有学生人数:"+studentService.findAll().size());

        List<Student> newStudentList =  studentService.findAll();
        sb.append("删除一个学生后，剩下的的学生姓名是：");
        for (Student stu :newStudentList){
            sb.append(stu.getName()+"\n");
        }



        //默认查询方法
//        studentService.findAll();
//        studentService.findOne(1l);
//        studentService.save(user);
//        studentService.delete(user);
//        studentService.count();
//        studentService.exists(1l);

        return sb.toString();

    }


    /**
     * 两表联查
     */
    @RequestMapping("/score")
    public String findStudentAndScore(){
        //studentScoreService.save(new Score(Long.parseLong("6"),88.5,92.0,78.0));
       //List<StudentInfo> infoList = studentScoreService.findStudentInfo("zhangsansan");
        //System.out.println("查询到zhangsansan"+infoList.size());
         Map<String,Object> map = studentScoreService.findStudentInfo("zhangsansan");

        StringBuffer sb = new StringBuffer();
        sb.append("学生姓名："+map.get("name"));
        sb.append("学生年龄："+map.get("age"));
        sb.append("学生语文成绩："+map.get("chineseScore"));
        sb.append("学生数学成绩："+map.get("mathScore"));
        sb.append("学生英语成绩："+map.get("englishScore"));
        System.out.println("两表联查查询的学生成绩："+sb.toString());
        return sb.toString();
    }


    /**
     * 分页查询
     * @return
     */
    @RequestMapping("/page")
    public String findPageQuery(){
        StringBuffer sb = new StringBuffer();
        int page=0,size=2;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        Page<Student> students = studentService.findALL(pageable);
        System.out.println("分页查询的学生姓名：");
        sb.append("分页查询的学生姓名：");
        for (Student stu: students){

            sb.append(stu.getName()+"\n");
            System.out.println(stu.getName()+"\n");

        }
       // studentService.findByName("zhangsansan", pageable);
        System.out.println("自定义sql查询的学生姓名是：");
        sb.append("自定义sql查询的学生姓名是：");
        Student student = studentService.zdyFindByname("zhangsansan");
        sb.append(student.getName()+"\n");
        System.out.println(student.getName()+"\n");
        return sb.toString();
    }
}
