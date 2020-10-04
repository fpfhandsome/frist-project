package com.example.demo.service;

import com.example.demo.entity.Student;

import java.util.List;

/**
 * @Author: fupengfei
 * @Description:
 * @Date: Create in 15:59 2020/10/2
 */
public interface StudentService {
    List<Student> getStudents();
    int addStudent(Student student);
}
