package com.this0.blog.service.impl;

import com.this0.blog.mapper.ArticleMapper;
import com.this0.blog.pojo.Article;
import com.this0.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Article> showAllByArticle(Article article) {
        return articleMapper.selectAllByArticle(article);
    }

    @Override
    @Transactional(readOnly = true)
    public Article findArticleById(Integer id) {
        return  articleMapper.selectArticleById(id);

    }

    @Override
    @Transactional(readOnly = true)
    public List<Article> showArticleByUid(Integer uid) {
        return articleMapper.selectArticleByUid(uid);
    }
}
