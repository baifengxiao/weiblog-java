package com.this0.blog.controller;

import com.this0.blog.pojo.Category;
import com.this0.blog.service.CategoryService;
import com.this0.blog.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/category")
@RestController
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/showAll")
    public Result<List<Category>> showAll() {
        List<Category> categoryList = categoryService.findAllCategory();
        return Result.ok(categoryList);
    }

}
