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
public class User extends Model<User> {
    @TableId(value = "id", type = IdType.AUTO)
    private long id;

    private String name;

    private String pwd;
}
