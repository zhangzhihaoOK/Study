package com.zzh.mybatis.DailyStudy.Excel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MysqlToExcel {
    public static void main(String[] args) throws Exception{
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet hssfSheet = hssfWorkbook.createSheet("MySQL导出的数据");
        HSSFRow row = hssfSheet.createRow(0);
        String[] rowName = { "户主姓名","户主身份证号","区市","街道","社区","家庭居住地址","救助金额","更新日期"};
        for (int i = 0; i < rowName.length; i++) {
            row.createCell(i).setCellValue(rowName[i]);
        }
        System.out.println("开始处理数据");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
        PreparedStatement ps = con.prepareStatement("select * from mz_lsjz_info");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            int j = rs.getRow();
            HSSFRow hssfRow = hssfSheet.createRow(j);
            for (int i = 0; i < rowName.length; i++) {
                hssfRow.createCell(i).setCellValue(rs.getString(i + 1));
            }
        }
        FileOutputStream fos = new FileOutputStream("C:\\Users\\dell\\Desktop\\test1.xlsx");
        hssfWorkbook.write(fos);
        System.out.println("数据处理完毕");
        fos.flush();
    }
}
