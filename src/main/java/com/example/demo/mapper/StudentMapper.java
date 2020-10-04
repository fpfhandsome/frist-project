package com.example.demo.mapper;

import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: fupengfei
 * @Description:
 * @Date: Create in 15:56 2020/10/2
 */
@Mapper
@Repository
public interface StudentMapper {
    List<Student> selectStudents();
    int insertStudent(Student student);
}
