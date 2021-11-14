package com.zzh.mybatis.DailyStudy.project02;


import java.io.File;

public class test {//快排

    public static void main(String[] args) {

        File file3 = new File("F:\\备份");
//        String[] list = file3.list();
//        for(String s : list){
//            System.out.println(s);
//        }
        System.out.println("*****************");
        File[] files = file3.listFiles();
        for(File f : files){
            System.out.println(f);
            if(f.isDirectory()){
                File[] filess = f.listFiles();
                for(File f1 : filess){
                    System.out.println(f1);
                }

            }
        }
    }
}
