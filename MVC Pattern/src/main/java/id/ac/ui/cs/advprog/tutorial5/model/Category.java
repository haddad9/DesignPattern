package id.ac.ui.cs.advprog.tutorial5.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;




@Entity
@Table(name = "Category")
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = "enrolledArticles")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private int id;

    @Column(name = "category_name")
    private String name;

    @Column(name = "num_articles")
    private int numArticles;


    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "category_article",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "article_id")
    )
    Set<Article> enrolledArticles = new HashSet<>();

    public Category(String name, int numArticles){
        this.name = name;
        this.numArticles = numArticles;
    }


    public void assignArticle(Article article) {
        enrolledArticles.add(article);
    }

    public void unAssign(Article article) {
        enrolledArticles.remove(article);
        numArticles-=1;
    }
}
