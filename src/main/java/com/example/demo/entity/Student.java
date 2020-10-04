package com.example.demo.entity;

import lombok.Data;

/**
 * @Author: fupengfei
 * @Description:
 * @Date: Create in 15:53 2020/10/2
 */
@Data
public class Student {
    private String Sno;
    private String Sname;
    private Integer Score;

    public Student(String sno, String sname, Integer score) {
        Sno = sno;
        Sname = sname;
        Score = score;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "Sno='" + Sno + '\'' +
                ", Sname='" + Sname + '\'' +
                ", Score='" + Score + '\'' +
                '}';
    }
}
