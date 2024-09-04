package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    ArticleStatus atr;

    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    public List<Article> getAllArticles() {
    	List<Article> list=articleRepository.findAll();
    	//Map<Map<String,String>, Map<String,List<Article>>> map=atr.respons(list);
    	return list;
    }

    public Optional<Article> getArticleById(Long id) {
        return articleRepository.findById(id);
    }

    public Optional<Article> updateArticle(Long id, Article articleDetails) {
        return articleRepository.findById(id).map(article -> {
            article.setTitle(articleDetails.getTitle());
            article.setAuthor(articleDetails.getAuthor());
            article.setSummary(articleDetails.getSummary());
            article.setPublishedAt(articleDetails.getPublishedAt());
            return articleRepository.save(article);
        });
    }

    public boolean deleteArticle(Long id) {
        return articleRepository.findById(id).map(article -> {
            articleRepository.delete(article);
            return true;
        }).orElse(false);
    }
}
