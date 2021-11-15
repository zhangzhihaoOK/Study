package com.zzh.mybatis.DailyStudy.Text;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class intersection {
    public static void main(String[] args) {
        //CollectionUtils.intersection()取两个集合的交集
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        a.add(1);
        a.add(88);
        a.add(4);
        a.add(13);
        a.add(23);
        a.add(55);
        a.add(32);
        b.add(22);
        b.add(1);
        b.add(88);
        b.add(22);
        Collection<Object> intersection = CollectionUtils.intersection(a, b);
        System.out.println(intersection);
    }
}
