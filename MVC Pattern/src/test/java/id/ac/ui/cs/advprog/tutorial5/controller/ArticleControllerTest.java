package id.ac.ui.cs.advprog.tutorial5.controller;


import id.ac.ui.cs.advprog.tutorial5.model.Article;
import id.ac.ui.cs.advprog.tutorial5.service.ArticleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = ArticleController.class)
public class ArticleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArticleService articleService;

    private Article article;
    private final String title = "Action";
    private final String isi = "Kisah sebuah action";

    @BeforeEach
    public void setUp() {
        article = new Article(title,isi);
    }

    @Test
    public void testPostArticle() throws Exception {
        when(articleService.createArticle(article)).thenReturn(article);

        mockMvc.perform(post("/article")
                .contentType(MediaType.APPLICATION_JSON).content(Mapper.mapToJson(article)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value(title))
                .andExpect(jsonPath("$.isi").value(isi));
    }

    @Test
    public void testGetListArticle() throws Exception {
        Iterable<Article> articlesList = List.of(article);
        when(articleService.getListArticle()).thenReturn(articlesList);

        mockMvc.perform(get("/article").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].title").value(title))
                .andExpect(jsonPath("$[0].isi").value(isi));
    }

    @Test
    public void testGetNonExistentArticleById() throws Exception {
        mockMvc.perform(get("/article/0").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetArticleById() throws Exception {
        when(articleService.getArticleById(0)).thenReturn(article);

        mockMvc.perform(get("/article/0").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title").value(title));
    }

    @Test
    public void testUpdateArticle() throws Exception {
        articleService.createArticle(article);
        String newTitle = "Fantasy";
        article.setTitle(newTitle);
        when(articleService.updateArticle(0, article)).thenReturn(article);

        mockMvc.perform(put("/article/0")
                .contentType(MediaType.APPLICATION_JSON).content(Mapper.mapToJson(article)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title").value(newTitle));
    }

    @Test
    public void testDeleteCategoryById() throws Exception {
        articleService.createArticle(article);

        mockMvc.perform(delete("/article/0").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
