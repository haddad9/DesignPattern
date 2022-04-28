package id.ac.ui.cs.advprog.tutorial5.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "editor")
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = "articles")
public class Editor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @CreatedDate
    @Column(name = "registered_at", nullable = false,updatable = false)
    private Date registeredAt;

    @Column(name = "written_articles")
    private int writtenArticles;

    @JsonIgnore
    @OneToMany(mappedBy = "editor")
    private Set<Article> articles = new HashSet<>();

    public Editor(String name, String email, int writtenArticles){
        this.name = name;
        this.email = email;
        this.writtenArticles = writtenArticles;
    }

    public void unAssign(Article a) {
        articles.remove(a);
        writtenArticles = articles.size();
    }

    public void assignArticle(Article a) {
        articles.add(a);
    }

//    @PreRemove
//    public void preRemove() {
//        for (Article a : articles) {
//            a.setEditor(null);
//        }
//    }
}
