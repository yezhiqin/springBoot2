package com.boot.test;

import com.boot.model.Score;
import com.boot.model.Student;
import com.boot.model.StudentInfo;
import com.boot.service.StudentScoreService;
import com.boot.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 接口测试
 * Created by yezhiqin on 2018/6/14.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentInterfaceTest {

    @Resource
    private StudentService studentService;

    @Resource
    private StudentScoreService studentScoreService;

    @Test
    public void testSave() {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

//        studentService.save(new Student("zhangsan", 18,"aa@126.com", "北京"));
//        studentService.save(new Student("lisi", 22,"lisi@126.com", "天津"));
//        studentService.save(new Student("wangwu", 19,"wangwu@126.com", "河北"));

        //查询所有
        System.out.println("总共有学生人数:"+studentService.findAll().size());

        //根据想你干嘛和邮箱查询
        Student student = studentService.findByNameOrAddress("zhangsan", "aa@126.com");

        System.out.println("姓名是:"+student.getName());


        student.setName("zhangsansan");
        Student newStu = studentService.save(student);

        System.out.println("修改"+student.getName()+"后姓名是:"+student.getName());


        //删除一个学生
//        studentService.delete(studentService.findByname("wangwu"));
//        System.out.println("删除一个学生后总共有学生人数:"+studentService.findAll().size());


        //默认查询方法
//        studentService.findAll();
//        studentService.findOne(1l);
//        studentService.save(user);
//        studentService.delete(user);
//        studentService.count();
//        studentService.exists(1l);

    }


    /**
     * 两表联查
     */
    @Test
    public void findStudentAndScore(){
        //studentScoreService.save(new Score(Long.parseLong("7"),88.5,92.0,78.0));
       //List<StudentInfo> infoList = studentScoreService.findStudentInfo("zhangsan");
        //System.out.println(infoList.size());
        // Map<String,String> map = studentScoreService.findStudentInfo("zhangsan");
        //System.out.println(map);
    }

    @Test
    public void queryPage(){
        int page=0,size=10;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        Page<Student> students= studentService.findALL(pageable);
        System.out.println(students);
        Student s = studentService.zdyFindByname("zhangsansan");
        System.out.println(s);
    }

}
