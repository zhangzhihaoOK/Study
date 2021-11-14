package com.zzh.mybatis.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.zzh.mybatis.entity.Person;
import com.zzh.mybatis.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonServiceImpl personService;

    //更新为雪花id
    @GetMapping("/SaveSnowId")
    public void SaveSnowId(){
//        long id = IdWorker.getId();
//        personService.save(new Person(id,"张三","20","12321","三亚"));
//        System.out.println("插入成功");
        List<Person> PersonList = personService.list();
        PersonList.forEach(i -> i.setId(IdWorker.getId()));
        personService.saveBatch(PersonList);
        System.out.println("数据已插入");
        personService.remove(new QueryWrapper<Person>().le("id",100));
        System.out.println("数据已更新");
    }
}
