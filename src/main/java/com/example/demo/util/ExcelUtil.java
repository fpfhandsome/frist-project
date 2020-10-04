package com.example.demo.util;

import com.example.demo.entity.Student;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Types.NUMERIC;
import static org.apache.poi.ss.usermodel.DataValidationConstraint.ValidationType.FORMULA;

/**
 * @Author: fupengfei
 * @Description:
 * @Date: Create in 10:01 2020/10/3
 */
public class ExcelUtil {
    public static Logger logger= LoggerFactory.getLogger(ExcelUtil.class);
    /**
     * 解析Excel数据
     * @param workbook Excel工作簿对象
     * @return 解析结果
     */
    public static List<Student> parseExcel(Workbook workbook) {
        List<Student> resultDataList = new ArrayList<>();
        // 解析sheet
        for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
            Sheet sheet = workbook.getSheetAt(sheetNum);

            // 校验sheet是否合法
            if (sheet == null) {
                continue;
            }

            // 获取第一行数据
            int firstRowNum = sheet.getFirstRowNum();
            Row firstRow = sheet.getRow(firstRowNum);
            if (null == firstRow) {
                logger.error("解析Excel失败，在第一行没有读取到任何数据！");
            }

            // 解析每一行的数据，构造数据对象
            int rowStart = firstRowNum + 1;
            int rowEnd = sheet.getPhysicalNumberOfRows();
            for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
                Row row = sheet.getRow(rowNum);

                if (null == row) {
                    continue;
                }
                //将row 转成Student对象
                Student student;
                String sno = row.getCell(0).getStringCellValue();
                String sname = row.getCell(1).getStringCellValue();
                int scoreInt= (int) row.getCell(2).getNumericCellValue();
                Integer score = Integer.valueOf(scoreInt);
                student=new Student(sno,sname,score);
                if (null == student) {
                    logger.error("第 " + row.getRowNum() + "行数据不合法，已忽略！");
                    continue;
                }
                resultDataList.add(student);
            }
        }

        return resultDataList;
    }

}
