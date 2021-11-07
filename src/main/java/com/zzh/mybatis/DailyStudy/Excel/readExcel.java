package com.zzh.mybatis.DailyStudy.Excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

//读取excel数据输出到控制台上

public class readExcel {
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\dell\\Desktop\\test.xlsx");
//        HSSFWorkbook:是操作Excel2003以前（包括2003）的版本，扩展名是.xls
//        XSSFWorkbook:是操作Excel2007的版本，扩展名是.xlsx
        //1.读取Excel文档对象
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        //2.获取要解析的表格（第一个表格）
        XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
        //获得最后一行的行号
        int lastRowNum = sheet.getLastRowNum();
        for (int i = 0; i <= lastRowNum; i++) {//遍历每一行
            //3.获得要解析的行
            XSSFRow row = sheet.getRow(i);
            //4.获得每个单元格中的内容（String）
            //设置类型
            row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
            row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
            row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
            String stringCellValue0 = row.getCell(0).getStringCellValue();
            String stringCellValue1 = row.getCell(1).getStringCellValue();
            String stringCellValue2 = row.getCell(2).getStringCellValue();
            System.out.println(stringCellValue0 + "--" + stringCellValue1 + "--" + stringCellValue2 + "--");
        }
    }
}
