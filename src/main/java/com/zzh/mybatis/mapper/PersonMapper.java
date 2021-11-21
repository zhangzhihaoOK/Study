package com.zzh.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzh.mybatis.entity.Person;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonMapper extends BaseMapper<Person> {

}
