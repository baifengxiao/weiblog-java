package com.this0.blog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.this0.blog.mapper.CategoryMapper;
import com.this0.blog.pojo.Category;
import com.this0.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Category> findAllCategory() {
        return categoryMapper.selectAllCategory();
    }

    @Override
    @Transactional(readOnly = true)
    public Map findAllByPage(Integer pageIndex, Integer pageSize, Category category) {

        Page<Object> page = PageHelper.startPage(pageIndex, pageSize);

        List<Category> categoryList = categoryMapper.selectByPage(category);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("total",page.getTotal());
        map.put("list",categoryList);
        return map;
    }

    @Override
    public Integer changeCategory(Category category) {
        return categoryMapper.updateCategory(category);
    }

    @Override
    public Integer addCategory(Category category) {
        return categoryMapper.insertCategory(category);
    }
}
