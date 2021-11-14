package com.zzh.mybatis.DailyStudy.Text;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Comparator {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        Collections.sort(list, new java.util.Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 < o2){
                    return  -1;
                }else  if(o1 > o2){
                    return 1;
                }else {
                    return 0;
                }
            }
        });
        System.out.println(list);
    }
}