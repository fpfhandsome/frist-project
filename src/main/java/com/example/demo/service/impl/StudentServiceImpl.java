package com.example.demo.service.impl;

import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: fupengfei
 * @Description:
 * @Date: Create in 16:01 2020/10/2
 */
@Service
public class StudentServiceImpl implements StudentService {
    final
    StudentMapper studentMapper;

    public StudentServiceImpl(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public List<Student> getStudents() {
        List<Student> students = studentMapper.selectStudents();
        return students;
    }

    @Override
    public int addStudent(Student student) {
        int i = studentMapper.insertStudent(student);
        if (i==0){
            throw new RuntimeException("插入异常");
        }
        return i;
    }
}
