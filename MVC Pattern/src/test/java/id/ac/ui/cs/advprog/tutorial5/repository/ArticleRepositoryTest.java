package id.ac.ui.cs.advprog.tutorial5.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Modifier;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArticleRepositoryTest {

    private Class<?> articleRepositoryClass;
    @BeforeEach
    public void setup() throws Exception {
        articleRepositoryClass = Class.forName("id.ac.ui.cs.advprog.tutorial5.repository.ArticleRepository");

    }

    @Test
    public void testArticleRepositoryIsAPublicInterface() {
        int classModifiers = articleRepositoryClass.getModifiers();

        assertTrue(Modifier.isPublic(classModifiers));
        assertTrue(Modifier.isInterface(classModifiers));
    }

    @Test
    public void testarticleRepositoryClassInstanceOfJPA(){
        Class<?> jpa = JpaRepository.class;
        assertTrue(jpa.isAssignableFrom(articleRepositoryClass));

    }
}
