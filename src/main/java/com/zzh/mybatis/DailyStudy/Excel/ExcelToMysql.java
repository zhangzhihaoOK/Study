package com.zzh.mybatis.DailyStudy.Excel;


import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ExcelToMysql {
    public static void main(String[] args) throws Exception{
        Workbook workbook = Workbook.getWorkbook(new File("C:\\Users\\dell\\Desktop\\test.xls"));
        Sheet sheet = workbook.getSheet("Sheet1");
        int m = sheet.getRows();
        int n = sheet.getColumns();
        Cell[][] cells = new Cell[m][n];
        System.out.println("开始写入数据");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cells[i][j] = sheet.getCell(j,i);
            }
        }
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
        PreparedStatement ps = con.prepareStatement("insert into exceltest(Src,Dst,Description) values (?,?,?)");
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ps.setString(j+1,cells[i][j].getContents());
            }ps.execute();
        }
        System.out.println("数据处理完毕");
    }

}
