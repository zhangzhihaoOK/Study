package com.zzh.mybatis.controller;

import com.zzh.mybatis.mapper.UserMapper;
import com.zzh.mybatis.service.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("/getUser")
    public User user(){
        User idUser = userMapper.getIdUser(5);
        return idUser;
    }
}
