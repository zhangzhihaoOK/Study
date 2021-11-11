package com.zzh.mybatis.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzh.mybatis.entity.User;
import com.zzh.mybatis.mapper.UserMapper;
import com.zzh.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @GetMapping("/getUser")
    public void user() {
        List<User> userList = userMapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @GetMapping("/getUser01")
    public void user01() {
        List<User> user01 = userMapper.getUser01();
        for (User user : user01) {
            System.out.println(user);
        }
    }
    //插入
    @GetMapping("/save")
    public void save() {
        //单个插入
        userService.save(new User(13, "仇九", "678932"));
        System.out.println("单个插入成功");

        //批量插入
        List<User> list = new ArrayList<>();
        list.add(new User(21, "rtyw", "54151"));
        list.add(new User(22, "ghjt", "98152"));
        list.add(new User(26, "ghjt", "98152"));
        list.add(new User(27, "ghjt", "98152"));
        list.add(new User(23, "asfg", "71223"));
        list.add(new User(24, "gdsf", "9822132"));
        userService.saveBatch(list);
        System.out.println("批量插入成功");
    }

    @GetMapping("/saveOrUpdate")
    //增加或更新.
    public void saveOrUpdate(){
        userService.saveOrUpdate(new User(1,"仇九", "8888888"));
        System.out.println("数据处理完成");
    }
    //更新
    @GetMapping("/update")
    public void update(){
        userService.updateById(new User(34,"董卓","59543631"));
        System.out.println("数据修改完成");
    }
    //删除
    @GetMapping("/remove")
    public void remove(){
        //按id删除
        userService.removeById(19);
        System.out.println("删除成功");

        //批量删除
        QueryWrapper<User> wrapper  = new QueryWrapper<>();
        wrapper.eq("name","rtyw");
        userService.remove(wrapper);
        System.out.println("数据删除成功");

        //mapper方法
        userMapper.deleteById(21);
        System.out.println("mapper删除完成");
    }
    //查询
    @GetMapping("/get")
    public void get(){
        //通过id查询
        User user = userService.getById(7);
        System.out.println(user);

        //查询所有
        List<User> list = userService.list();
        System.out.println(list);

        //查询列表
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","ghjt");
        List<User> list1 = userService.list(wrapper);
        System.out.println(list1);

        //allEq  全部等于
        QueryWrapper<User> allEqWrapper = new QueryWrapper<>();
        Map<String,String> allEqMap = new HashMap<>();
        allEqMap.put("name","ghjt");
        allEqMap.put("pwd","98152");
        allEqMap.put("id","27");
        allEqWrapper.allEq(allEqMap);
        List<User> allEqList = userService.list(allEqWrapper);
        System.out.println(allEqList);

        //ne 不等于
        QueryWrapper<User> neWrapper = new QueryWrapper<>();
        neWrapper.ne("name","ghjt");
        List<User> neList = userService.list(neWrapper);
        System.out.println(neList);

        //gt  大于  ge 大于等于  lt 小于  le 小于等于
        QueryWrapper<User> gtWrapper = new QueryWrapper<>();
        gtWrapper.gt("id","20");
        List<User> gtList = userService.list(gtWrapper);
        System.out.println(gtList);

        //between A and B  值在AB中间   notBetween
        QueryWrapper<User> betweenWrapper = new QueryWrapper<>();
        betweenWrapper.between("id","20","30");
        List<User> betweenList = userService.list(betweenWrapper);
        System.out.println(betweenList);

        //like 模糊查询  notLike   likeLeft  likeRight  null  isNotNull
        QueryWrapper<User> likeWrapper = new QueryWrapper<>();
        likeWrapper.like("name","s");
        List<User> likeList = userService.list(likeWrapper);
        System.out.println(likeList);

        //in 在集合范围中   notIn
        QueryWrapper<User> inWrapper = new QueryWrapper<>();
        List<String> list2 = new ArrayList<>();
        list2.add("张三");
        list2.add("李四");
        list2.add("王五");
        list2.add("赵六");
        inWrapper.in("name",list2);
        List<User> inList = userService.list(inWrapper);
        System.out.println(inList);

        //oderBy
        wrapper.orderBy(true,true,"name");
    }
    //分页
    @GetMapping("/page")
    public IPage<User> page(){
        IPage<User> page = new Page<>();
        page.setCurrent(1);
        page.setSize(5);
        userService.page(page);
        return page;
    }
    //map的输出方式
    @GetMapping("/map")
    public void map(){
        Map<String,Integer> map = new HashMap<>();
        map.put("张三",1);
        map.put("李四",2);
        map.put("王五",3);
        map.put("赵六",4);
        map.put("孙七",5);
        map.put("仇九",6);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next.getKey() + ":" + next.getValue());
        }
    }
    //查询数据条数
    @GetMapping("/count")
    public void count(){
        //查询共有多少数据
        long allCount = userService.count();
        System.out.println(allCount);
        //按条件查询
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","ghjt");
        long warpCount = userService.count(wrapper);
        System.out.println(warpCount);
    }
}
