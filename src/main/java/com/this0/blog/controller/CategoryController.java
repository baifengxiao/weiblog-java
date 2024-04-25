package com.this0.blog.controller;

import com.this0.blog.pojo.Category;
import com.this0.blog.service.CategoryService;
import com.this0.blog.utils.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/category")
@RestController
@CrossOrigin
@Tag(name = "文章分类模块")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    @Operation(summary = "查询所有分类")
    public Result<List<Category>> showAll() {
        List<Category> categoryList = categoryService.findAllCategory();
        return Result.ok(categoryList);
    }

    @PostMapping("/{pageIndex}/{pageSize}")
    @Operation(summary = "分页查询分类")
    public Result findAllByPage(@PathVariable Integer pageIndex,@PathVariable Integer pageSize , @RequestBody Category category){
        Map allByPage = categoryService.findAllByPage(pageIndex, pageSize, category);
        return Result.ok(allByPage);
    }

}
