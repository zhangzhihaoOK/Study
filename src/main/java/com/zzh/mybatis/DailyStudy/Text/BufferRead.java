package com.zzh.mybatis.DailyStudy.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.*;

public class BufferRead {
    public static void main(String[] args) {

        BufferedReader bis = null;
        BufferedWriter bos = null;
        try {
            bis = new BufferedReader(new FileReader(new File("zzh.test\\hello.txt")));
            bos = new BufferedWriter(new FileWriter(new File("zzh.test\\hello2.txt")));

            char[] cbuf = new char[5];
            int len;

            while((len = bis.read(cbuf)) != -1){
                bos.write(cbuf,0,len);
                bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}