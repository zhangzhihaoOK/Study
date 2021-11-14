package com.zzh.mybatis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzh.mybatis.entity.Person;
import com.zzh.mybatis.mapper.PersonMapper;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements IService<Person> {

}
