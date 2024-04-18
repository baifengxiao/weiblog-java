package com.this0.blog.service;

import com.this0.blog.pojo.Article;

import java.util.List;

public interface ArticleService {

    List<Article> showAllByArticle(Article article);

    Article findArticleById(Integer id);
}
