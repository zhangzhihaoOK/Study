package com.zzh.mybatis.DailyStudy.project02;

import java.util.Scanner;

public class CMUtility {
    public static void main(String[] args) {
        //System.out.println(readMenuSelection());
    }
    private static Scanner scanner = new Scanner(System.in);
    private static String readKeyBoard(int limit,boolean blank){
        for (;;) {
            String str = scanner.nextLine();
            if (str.length()>0 && str.length()<=limit) {
                return str;
            } else if (blank) {
                return str;
            }else{
                System.out.println("请输入长度不超过"+limit+"的指令");
            }
        }

    }

    public static char readMenuSelection(){
        //获取功能选择
        char c;
        for(;;){
            String str = readKeyBoard(1,false);
            c = str.charAt(0);
            if (c=='1' || c=='2' || c=='3' || c=='4' || c=='5' ) {
                return c;
            } else {
                System.out.println("选择错误，请重新输入。");
            }
        }
    }

    public static char readChar(){
        //获取性别
        String str = readKeyBoard(1,false);
        return str.charAt(0);
    }

    public static char readChar(char defaultValue){
        //修改性别信息时，不输入信息直接回车
        String str = readKeyBoard(1,true);
        return (str.length()==0)? defaultValue : str.charAt(0);
    }

    public static int readInt(){
        //获取年龄
        int n;
        for(;;){
            String str = readKeyBoard(2,false);
            try{
                n = Integer.parseInt(str);
                return n;
            }catch (NumberFormatException e) {
                System.out.println("数字输入错误，请重新输入。");
            }
        }
    }

    public static int readInt(int defaultValue){
        //修改年龄信息时，不输入信息直接回车
        int n;
        for(;;){
            String str = readKeyBoard(2,true);
            if (str.equals("")) {
                return defaultValue;
            }
            try{
                n = Integer.parseInt(str);
                return n;
            }catch (NumberFormatException e) {
                System.out.println("数字输入错误，请重新输入。");
            }
        }
    }

    public static String readString(int limit){
        //姓名、电话、邮箱的输入
        return readKeyBoard(limit,false);
    }

    public static String readString(int limit,String defaultValue){
        //修改姓名、电话、邮箱时，不输入信息直接回车
        String str = readKeyBoard(limit,true);
        return str.equals("") ? defaultValue : str;
    }

    public static char readConfirmSelection(){
        //获取确认的输入
        for(;;){
            String str = readKeyBoard(1,false).toUpperCase();
            char c = str.charAt(0);
            if (c=='Y' || c=='N') {
                return c;
            } else {
                System.out.println("选择错误，请输入Y/N");
            }
        }
    }
}