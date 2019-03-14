package com.boot.controller;

import com.boot.model.Score;
import com.boot.model.Student;
import com.boot.service.ScoreService;
import com.boot.service.StudentService;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 学生controller
 * Created by yezhiqin on 2018/6/25.
 */
@RestController
public class StudentController {


    @Resource
    private StudentService studentService;


    @Resource
    private ScoreService scoreService;

    /**
     * 新增学生
     * @param student
     * @return
     */
    @RequestMapping("/add")
    public int saveStudent(Student student){
        return this.studentService.addStudent(student);
    }


    /**
     * 删除学生
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public int deleteStudent(Long id){
        return this.studentService.deleteStudent(id);
    }


    /**
     * 修改学生信息
     * @param student
     * @return
     */
    @RequestMapping("/update")
    public int updateStudent(Student student){
        return this.studentService.updateStudent(student);
    }

    /**
     * 查询学生信息
     * @param id
     * @return
     */
    @RequestMapping("/select")
    public Student findStudentById(Long id){
        return this.studentService.selectStudentById(id);
    }


    @ResponseBody
    @RequestMapping("/getList")
    public Object findAllStudent(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize){
        return studentService.selectAllStudent(pageNum,pageSize);
    }

    @ResponseBody
    @RequestMapping("/getAllStudentScore")
    public Object findAllStudentScore(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize){
        return studentService.findAllStudentScore(pageNum,pageSize);
    }


    /**
     * 测试多数据获取数据
     * @return
     */
    @ResponseBody
    @RequestMapping("/multiDataSourceQueryDB")
    public String multiDataSourceFindDB(){

        Score score = this.scoreService.findByKeyScore("1");

        System.out.println("成绩"+score.getChineseScore());

        String rs = "";

        List<Student> studentList = this.studentService.findAllStudent();

        List<Score> scoreList = this.scoreService.findStudentScore();

        Gson gson = new Gson();

        String stuStr = gson.toJson(studentList).toString();

        String scoreStr = gson.toJson(scoreList).toString();

        rs += "学生数据库："+stuStr+"\n"+"成绩库数据"+scoreStr;

        return rs;
    }

//    @RequestMapping("/getList")
//    public Page<Student> getList(HttpServletRequest request) {
//        Map<String,String> map = new HashMap<>();
//        map.put("beginLine","0");
//        map.put("pageSize","2");
//        List<Student> users = studentService.selectAllStudent(map);
//        long count = this.studentService.selectStudentCount();
//        Page page = new Page(0,count,1,users);
//        return page;
//    }

}
