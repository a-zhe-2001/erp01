package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
//实体类，数据库
@Data
public class User {
    private int id;
    private String no;
    private String name;
    private String password;
    private  int sex;
    private int roleId;
    private String phone;
    @TableField("isvalid")
    private String isValid;

}
