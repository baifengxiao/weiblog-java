package com.this0.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long uid; //用户id
    private String username;//用户名称
    private String password;//密码
    private String phone;//手机号
    private String introduction;//个人介绍
    private Date create_time;
    private Date update_time;
}
