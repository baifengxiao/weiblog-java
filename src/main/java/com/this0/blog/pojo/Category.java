package com.this0.blog.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "文章分类对象")
public class Category {

    @Schema(description = "分类id")
    private Long cid;
    @Schema(description = "分类名称")
    private String cname;
    private Date create_time;
    private Date update_time;
}
