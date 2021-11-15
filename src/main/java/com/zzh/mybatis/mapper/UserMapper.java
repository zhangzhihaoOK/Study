package com.zzh.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzh.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    //查询全部用户
    List<User> getUserList();
    //模糊查询
    List<User> getVagueUser(String name);
    //根据id查询用户
    User getIdUser(int id);
    //可以用多个条件查询
    User getIdUser2(Map<String,Object> map);

    //增加用户
    int addUser(User user);
    //万能的map 添加
    int addUser2(Map<String,Object> map);

    //修改用户
    int updateUser(User user);

    //删除用户
    int deleteUser(int id);
    //使用map删除用户
    int deleteUser2(Map<String,Object> map);


    List<User> getUserByLimit(Map<String,Integer> map);

    //左连接进行查询
    List<User> getUser01();
}
