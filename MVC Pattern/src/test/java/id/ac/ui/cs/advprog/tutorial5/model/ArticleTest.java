package id.ac.ui.cs.advprog.tutorial5.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArticleTest {

    private Class<?> ArticleClass;

    @BeforeEach
    public void setUp() throws Exception {
        ArticleClass = Class
                .forName("id.ac.ui.cs.advprog.tutorial5.model.Article");
    }

    @Test
    public void articleIsAPublicClass() {
        int classModifiers = ArticleClass.getModifiers();

        assertTrue(Modifier.isPublic(classModifiers));

    }

    @Test
    public void testArticleIsNotAbstractClass() {
        assertFalse(Modifier.isAbstract(ArticleClass.getModifiers()));


    }

    @Test
    public void testArticleGetTitleReturnsValidValue(){
        Article ArticleMock = Mockito.mock(
                Article.class,
                Mockito.withSettings()
                        .useConstructor("title","isi" )
                        .defaultAnswer(Mockito.CALLS_REAL_METHODS));

        assertTrue(ArticleMock.getTitle().equals("title"));
    }

    @Test
    public void testArticleGetIsiReturnsValidValue(){
        Article ArticleMock = Mockito.mock(
                Article.class,
                Mockito.withSettings()
                        .useConstructor("title","isi" )
                        .defaultAnswer(Mockito.CALLS_REAL_METHODS));
        assertTrue(ArticleMock.getIsi().equals("isi"));
    }

    @Test
    public void testArticleGetIdReturnsValidValue(){
        Article ArticleMock = Mockito.mock(
                Article.class,
                Mockito.withSettings()
                        .useConstructor("title","isi" )
                        .defaultAnswer(Mockito.CALLS_REAL_METHODS));
        ArticleMock.setId(1);
        assertTrue(ArticleMock.getId() == 1);
    }
}
