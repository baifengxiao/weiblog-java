package com.this0.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private Long cid;
    private String cname; //分类名称
    private Date create_time;
    private Date update_time;
}
