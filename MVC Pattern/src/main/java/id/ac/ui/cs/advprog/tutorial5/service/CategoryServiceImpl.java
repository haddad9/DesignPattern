package id.ac.ui.cs.advprog.tutorial5.service;

import id.ac.ui.cs.advprog.tutorial5.model.Article;
import id.ac.ui.cs.advprog.tutorial5.model.Category;
import id.ac.ui.cs.advprog.tutorial5.repository.ArticleRepository;
import id.ac.ui.cs.advprog.tutorial5.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Category getCategoryById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Iterable<Category> getListCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(Category category) {
        categoryRepository.save(category);
        return category;
    }

    @Override
    public Category updateCategory(int id, Category category) {
        category.setId(id);
        categoryRepository.save(category);
        return category;
    }

    @Override
    public void deleteCategoryById(int id) {

        Category category = this.getCategoryById(id);

        if(category != null){
            Set<Article> articles = category.getEnrolledArticles();
            if(articles.size() != 0){
                for(Article a: articles){
                    a.removeCategory(category);
                    articleRepository.save(a);
                    category.unAssign(a);
                    categoryRepository.save(category);

                }
            }


            categoryRepository.delete(category);

        }
    }

    @Override
    public Category assignArticle(int categoryId, int articleId) {

        Article article = articleRepository.findById(articleId);
        Category category = categoryRepository.findById(categoryId);
        if(category != null && article != null){
            category.assignArticle(article);

            category.setNumArticles(category.getEnrolledArticles().size());
        }
        return  categoryRepository.save(category);


    }
}
