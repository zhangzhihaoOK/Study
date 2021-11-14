package com.zzh.mybatis.DailyStudy.Text;

import java.io.File;
import java.io.IOException;


public class ThrowJpg {
    public static void main(String[] args) throws IOException {
        File file= new File("D:\\src\\src0");
        String[] sss = file.list();
        for(String s : sss){
            if(s.endsWith(".jpg")){
                System.out.println(s);
            }
        }
    }
}