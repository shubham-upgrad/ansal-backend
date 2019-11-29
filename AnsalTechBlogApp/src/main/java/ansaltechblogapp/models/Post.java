package ansaltechblogapp.models;

import javax.persistence.*;
import java.util.Date;
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
}
