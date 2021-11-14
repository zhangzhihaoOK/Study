package com.zzh.mybatis.DailyStudy.Text;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileRead {
    public static void main(String[] args){
        FileReader fr = null;
        FileWriter fw = null;
        try {
//构造器为false或空  表示对文件覆盖
//构造器为true   表示对文件追加内容
            File file = new File("zzh.test\\hello.txt");
            fr = new FileReader(file);
            File file1 = new File("hello1.txt");
            fw = new FileWriter(file1,true);
            char[] cbuf = new char[5];
            int len;
            while((len = fr.read(cbuf)) != -1){
                //            for (int i = 0; i < len; i++) {
                //                fw.write(cbuf[i]);
                //            }
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

