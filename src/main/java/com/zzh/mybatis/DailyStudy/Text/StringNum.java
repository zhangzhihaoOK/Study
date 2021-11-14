package com.zzh.mybatis.DailyStudy.Text;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StringNum {
    public static void main(String[] args) {

        BufferedReader bis = null;
        try {
            bis = new BufferedReader(new FileReader("zzh.test\\雪中.txt"));

            char[] cbuf = new char[50];
            Map<Character,Integer> map = new HashMap<>();
            int len;
            int value = 1;
            while((len = bis.read(cbuf)) != -1){
                for (int i = 0; i < len; i++) {
                    if(map.containsKey(cbuf[i])){
                        map.put(cbuf[i],value+1);
                    }else{
                        map.put(cbuf[i],value);
                    }
                }
            }
            Set<Map.Entry<Character, Integer>> entries = map.entrySet();
            for (Object o : entries) {
                System.out.println(o);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
