package com.zzh.mybatis.DailyStudy.Text;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;

public class DailyTest {
    public static void main(String[] args) {
        String id = IdWorker.getTimeId();
        System.out.println(id);

        String uuid = IdWorker.get32UUID();
        System.out.println(uuid);

        long id1 = IdWorker.getId();
        System.out.println(id1);

        com.zzh.mybatis.DailyStudy.snowId.IdWorker idWorker = new com.zzh.mybatis.DailyStudy.snowId.IdWorker();
        long l = idWorker.nextId();
        System.out.println(l);
    }
}
