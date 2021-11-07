package com.zzh.mybatis.mapper;

import com.zzh.mybatis.service.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
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
}
