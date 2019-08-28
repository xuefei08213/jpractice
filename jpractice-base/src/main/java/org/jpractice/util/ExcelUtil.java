package org.jpractice.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 解析Excel工具类
 */
public class ExcelUtil {

    public static void analysisExcel(String execelFilePath){
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(execelFilePath));
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            for(Row row : sheet){
                for(Cell cell : row){
                    System.out.println(cell.getStringCellValue());
                }
            }
        }catch (Exception e){

        }

    }

    public static void main(String[] args){
        ExcelUtil.analysisExcel("/Users/xuefei/Documents/人员组织中台/副本ERP系统-人资表字段及来源.xlsx");
    }


}
