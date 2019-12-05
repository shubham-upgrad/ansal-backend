package ansaltechblogapp.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="posts")
public class Post {
    /***
     IDENTITY : AUTO_INCREMENT column
     SEQUENCE : SEQUENCE TABLE TO SIMULATE SEQUENCE OF NUMBERS
     TABLE : A NORMAL TABLE(NOT SEQUENCE) to keep record of PRIMARY KEY(inefficient)
     AUTO : Let HIBERNATE decide based on dialect...which one is the best
     usually AUTO selects SEQUENCE
     ***/
    @Id // This annotation is used to define a primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String title;
    @Column
    private String body;
    @Column(name="post_date")
    private Date date;
    // Any field marked @Transient will not be mapped to the table column
    // So using @Transient you can define fields that are required by your (java)app
    // and have no use in database.
    @Transient
    private String javaBlog;
    @Transient
    private String springBlog;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToMany(fetch=FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<Category> categories = new ArrayList<>();


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post(String title, String body, Date date) {
        this.title = title;
        this.body = body;
        this.date = date;
    }

    public Post() {

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJavaBlog() {
        return javaBlog;
    }

    public void setJavaBlog(String javaBlog) {
        this.javaBlog = javaBlog;
    }

    public String getSpringBlog() {
        return springBlog;
    }

    public void setSpringBlog(String springBlog) {
        this.springBlog = springBlog;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
