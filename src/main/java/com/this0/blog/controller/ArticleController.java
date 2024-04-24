package com.this0.blog.controller;

import com.this0.blog.pojo.Article;
import com.this0.blog.service.ArticleService;
import com.this0.blog.utils.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/article")
@RestController
@CrossOrigin
@Tag(name = "文章模块")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/showAll")
    @Operation(summary = "查询所有文章")
    public Result showAll(@RequestBody Article article) {
        List<Article> articleList = articleService.showAllByArticle(article);
        return Result.ok(articleList);

    }
    @GetMapping("/{id}")
    @Operation(summary = "根据文章id查询文章")
    public Result selectArticleById(@PathVariable("id") Integer id) {
        Article article = articleService.findArticleById(id);
        return Result.ok(article);

    }
    @GetMapping("/showAllByUid/{uid}")
    @Operation(summary = "根据文章uid查询文章")
    public Result showAllByUid(@PathVariable("uid") Integer uid) {
        List<Article> articleList = articleService.showArticleByUid(uid);
        return Result.ok(articleList);

    }

    @PutMapping("/")
    @Operation(summary = "根据文章id修改文章")
    public Result changeArticle(@RequestBody Article article){
        Integer result = articleService.changeArticle(article);
        if (result>0){
            return Result.ok();
        }
        return Result.fail();
    }

}
