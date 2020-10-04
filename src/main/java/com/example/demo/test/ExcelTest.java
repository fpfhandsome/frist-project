package com.example.demo.test;

import com.example.demo.DemoApplication;
import com.example.demo.service.impl.ExcelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: fupengfei
 * @Description:
 * @Date: Create in 9:42 2020/10/3
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class ExcelTest {
    @Autowired
    ExcelService excelService;

    @Test
    public void test1() {
        excelService.getDataToExcel();
    }
    @Test
    public void test2(){
        excelService.getDataToDb();
    }
}
