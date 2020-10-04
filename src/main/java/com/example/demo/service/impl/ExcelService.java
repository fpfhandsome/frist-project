package com.example.demo.service.impl;

import com.example.demo.entity.Student;
import com.example.demo.util.ExcelUtil;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

/**
 * @Author: fupengfei
 * @Description:
 * @Date: Create in 8:52 2020/10/3
 */
@Service
public class ExcelService {
    final
    StudentServiceImpl studentService;

    public ExcelService(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    public void getDataToExcel(){
        List<Student> students = studentService.getStudents();
        HSSFWorkbook workbook = new HSSFWorkbook();
        if (workbook==null){
            throw new RuntimeException("没有生成workbook");
        }
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontName("宋体");

        HSSFSheet sheet = workbook.createSheet("StudentScore");
        if (sheet==null){
            throw new RuntimeException("生成sheet失败");
        }
        //创建标题
        HSSFRow titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("学号");
        titleRow.createCell(1).setCellValue("姓名");
        titleRow.createCell(2).setCellValue("成绩");
        for (int i= 0;i < students.size();i++){
            int lastRowNum = sheet.getLastRowNum();
            HSSFRow dataRow = sheet.createRow(lastRowNum + 1);
            dataRow.createCell(0).setCellValue(students.get(i).getSno());
            dataRow.createCell(1).setCellValue(students.get(i).getSname());
            dataRow.createCell(2).setCellValue(students.get(i).getScore());
        }
        String src="D:\\学生成绩表.xls";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(src);
            workbook.write(fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void getDataToDb(){
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream("D:\\学生成绩表.xls"));
            List<Student> students = ExcelUtil.parseExcel(workbook);
            for (int i=0;i<students.size();i++){
                studentService.addStudent(students.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
