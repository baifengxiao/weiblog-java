package com.this0.blog.mapper;

import com.this0.blog.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
    List<Article> selectAllByArticle(Article article);
}
