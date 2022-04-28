package id.ac.ui.cs.advprog.tutorial5.service;

import id.ac.ui.cs.advprog.tutorial5.model.Article;
import id.ac.ui.cs.advprog.tutorial5.model.Category;
import org.springframework.stereotype.Service;



public interface ArticleService  {
    Iterable<Article> getListArticle();

    Article createArticle(Article category);

    Article getArticleById(int id);

    Article updateArticle(int id, Article article);


    void deleteArticleById(int id);

    Article assignEditor(int editorId, int articlesId);
}
