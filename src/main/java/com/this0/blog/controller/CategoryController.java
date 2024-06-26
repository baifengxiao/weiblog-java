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
    @PutMapping
    @Operation(summary = "修改分类名称")
    public Result changeCategory(@RequestBody Category category){
        Integer result = categoryService.changeCategory(category);
        if (result>0){
            return Result.ok();
        }
        return Result.fail();

    }

    @PostMapping
    @Operation(summary = "新增分类")
    public Result addCategory(@RequestBody Category category) {
        Integer result = categoryService.addCategory(category);
        if (result > 0) {
            return Result.ok();
        }
        return Result.fail();

    }

    @DeleteMapping("/{cid}")
    @Operation(summary = "删除分类")
    public Result removeCategory(@PathVariable Integer cid) {
        Integer result = categoryService.removeCategory(cid);
        if (result > 0) {
            return Result.ok();
        }
        return Result.fail();

    }

}
