package com.this0.blog.mapper;

import com.this0.blog.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    List<Category> selectAllCategory();
    List<Category> selectByPage(Category category);

    Integer updateCategory(Category category);
}
