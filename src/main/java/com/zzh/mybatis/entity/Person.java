package com.zzh.mybatis.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class Person extends Model<Person> {
    @TableId(value = "id", type = IdType.AUTO)
    private long id;

    private String name;

    private String age;

    private String pwd;

    private String address;
}
