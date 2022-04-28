package id.ac.ui.cs.advprog.tutorial5.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "article")
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"categories","editor"})

public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private int id;

    @CreationTimestamp
    @Column(name="created_at", nullable = false,updatable = false)
    private Date createdAt;


    @UpdateTimestamp
    @Column(name="updated_at",updatable = true)
    private Date updatedAt;


    @Column(name="title")
    private String title;

    @Column(name="isi")
    private String isi;


    @ManyToOne
    @JoinColumn(name = "editor_id", referencedColumnName = "id")
    private Editor editor;


    @ManyToMany(mappedBy = "enrolledArticles")
    private Set<Category> categories = new HashSet<>();

    public Article(String title, String isi){
        this.title = title;
        this.isi = isi;
    }


    public void removeCategory(Category category) {
        categories.remove(category);
    }
}
