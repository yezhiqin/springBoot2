package com.boot.controller;

import com.boot.model.Student;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 学生类controller
 * Created by zhoujh on 2018/06/11
 */

@RestController
public class StudentController {

    @RequestMapping(value = "/getStudent", method= RequestMethod.GET)
    public Student getUser() {
        Student student=new Student();
        student.setName("zhoujunhong");
        student.setAge(25);
        student.setAddress("北京市海淀区八里庄街道");
        return student;
    }

    @RequestMapping("/getStudents")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<Student>();
        Student student=new Student();
        student.setName("zhoujunhong");
        student.setAge(25);
        student.setAddress("北京市海淀区八里庄街道");
        students.add(student);
        Student studentTwo=new Student();
        studentTwo.setName("zaiyiqi");
        studentTwo.setAge(22);
        studentTwo.setAddress("北京市海淀区八里庄街道");
        students.add(studentTwo);
        return students;
    }

    /**
     * 使用 Url 进行传参，这种形式的传参地址栏会更加美观
     * @param name
     * @return
     */
    @RequestMapping(value="get/{name}", method=RequestMethod.GET)
    public Student get(@PathVariable String name) {
        Student student = new Student();
        student.setName(name);
        return student;
    }

    /**
     * 传入一个属性 name，其直接使用对象接收
     * @param student
     * @return
     */
    @RequestMapping(name="/getStudent")
    public String getUser(Student student) {

        return student.getName();
    }

    /**
     * 参数校验
     * @param student
     * @param result
     */
    @RequestMapping("/saveStudent")
    public String saveUser(@Valid Student student, BindingResult result) {
        System.out.println("student:"+student.getName());
        String errorInfo = "";
        if(result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                errorInfo = error.getCode()+ "-" + error.getDefaultMessage();
                System.out.println(error.getCode()+ "-" + error.getDefaultMessage());
            }
        }
        return errorInfo;
    }
}