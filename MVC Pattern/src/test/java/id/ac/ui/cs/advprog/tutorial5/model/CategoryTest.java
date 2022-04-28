package id.ac.ui.cs.advprog.tutorial5.model;

import id.ac.ui.cs.advprog.tutorial5.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CategoryTest {

    private Class<?> CategoryClass;

    @BeforeEach
    public void setUp() throws Exception {
        CategoryClass = Class
                .forName("id.ac.ui.cs.advprog.tutorial5.model.Category");
    }

    @Test
    public void categoryIsAPublicClass() {
        int classModifiers = CategoryClass.getModifiers();

        assertTrue(Modifier.isPublic(classModifiers));

    }

    @Test
    public void testCategoryIsNotAbstractClass() {
        assertFalse(Modifier.isAbstract(CategoryClass.getModifiers()));


    }

    @Test
    public void testCategoryGetNumArticlesReturnsValidValue(){
        Category CategoryMock = Mockito.mock(
                Category.class,
                Mockito.withSettings()
                        .useConstructor("name",1 )
                        .defaultAnswer(Mockito.CALLS_REAL_METHODS));

        assertTrue(CategoryMock.getNumArticles() == 1);
    }

    @Test
    public  void testAssignArticleIncrementEnrolledArticlesSize(){
        Category CategoryMock = Mockito.mock(
                Category.class,
                Mockito.withSettings()
                        .useConstructor("name",1 )
                        .defaultAnswer(Mockito.CALLS_REAL_METHODS));
        Article articleMock  = Mockito.mock(Article.class);
        CategoryMock.assignArticle(articleMock);
        assertTrue(CategoryMock.getEnrolledArticles().size() == 1);

    }
    @Test
    public void testCategoryGetIdReturnsValidValue(){
        Category CategoryMock = Mockito.mock(
                Category.class,
                Mockito.withSettings()
                        .useConstructor("name",1 )
                        .defaultAnswer(Mockito.CALLS_REAL_METHODS));
        CategoryMock.setId(1);
        assertTrue(CategoryMock.getId() == 1);
    }

}
