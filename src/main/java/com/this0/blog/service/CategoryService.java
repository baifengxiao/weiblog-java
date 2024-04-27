package com.this0.blog.service;

import com.this0.blog.pojo.Category;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    List<Category> findAllCategory();
    Map findAllByPage(Integer pageIndex, Integer pageSize, Category category );

    Integer changeCategory(Category category);
    Integer addCategory(Category category);
}
