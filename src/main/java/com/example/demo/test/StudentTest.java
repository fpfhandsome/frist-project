package com.example.demo.test;

import com.example.demo.DemoApplication;
import com.example.demo.entity.Student;
import com.example.demo.service.impl.StudentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: fupengfei
 * @Description:
 * @Date: Create in 15:31 2020/9/30
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class StudentTest{
    @Autowired
    StudentServiceImpl studentService;
    @Test
    public void test1(){
        List<Student> students = studentService.getStudents();
        for (Student student:students){
            System.out.println(student.toString());
        }
    }
    @Test
    public void test2(){
        Student student=new Student("s06","李四",98);
        int i = studentService.addStudent(student);
        System.out.println(i);
    }
    public void test3(){
        System.out.println("kkkk");
    }
}
