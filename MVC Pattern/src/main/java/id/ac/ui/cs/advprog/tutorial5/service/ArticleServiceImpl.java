package id.ac.ui.cs.advprog.tutorial5.service;

import id.ac.ui.cs.advprog.tutorial5.model.Article;
import id.ac.ui.cs.advprog.tutorial5.model.Category;
import id.ac.ui.cs.advprog.tutorial5.model.Editor;
import id.ac.ui.cs.advprog.tutorial5.repository.ArticleRepository;
import id.ac.ui.cs.advprog.tutorial5.repository.CategoryRepository;
import id.ac.ui.cs.advprog.tutorial5.repository.EditorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleRepository articleRepository;


    @Autowired
    EditorRepository editorRepository;

    @Autowired
    CategoryRepository categoryRepository;




    @Override
    public Iterable<Article> getListArticle() {
        return articleRepository.findAll();
    }

    @Override
    public Article createArticle(Article article) {
        articleRepository.save(article);
        return article;
    }

    @Override
    public Article getArticleById(int id) {
        return articleRepository.findById(id);
    }

    @Override
    public Article updateArticle(int id, Article article) {
        article.setId(id);
        articleRepository.save(article);
        return article;

    }


    //ManyToOne with Editor
    //ManyToMany with Category
    @Override
    public void deleteArticleById(int id) {
        Article article = articleRepository.findById(id);
        if(article!=null){
            Editor editor = article.getEditor();
            Set<Category> categories = article.getCategories();
            if(editor!=null){
                editor.unAssign(article);
                editorRepository.save(editor);

            }


            if(categories.size() != 0){
                for(Category c: categories){
                    c.unAssign(article);
                    categoryRepository.save(c);
                    article.removeCategory(c);
                    articleRepository.save(article);


                }
            }


            articleRepository.delete(article);
        }
    }




    @Override
    public Article assignEditor(int editorId, int articleId) {
        Article article = articleRepository.findById(articleId);
        Editor editor = editorRepository.findById(editorId);

        if(editor!=null){
            article.setEditor(editor);
            editor.assignArticle(article);
            editor.setWrittenArticles(editor.getArticles().size());

            editorRepository.save(editor);

        }

        return articleRepository.save(article);
    }
}
