package ansaltechblogapp.services;

import ansaltechblogapp.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService {
    public ArrayList<Post> getAllPosts(){
        Post p1=new Post("Post 1","Body of Post 1",new Date());
        Post p2=new Post("Post 2","Body of Post 2",new Date());
        Post p3=new Post("Post 3","Body of Post 3",new Date());
        // Creating list of posts
        ArrayList<Post> posts=new ArrayList<>();

        posts.add(p1);
        posts.add(p2);
        posts.add(p3);
        // Passing list of posts to the index using Model
        return posts;
    }

    public ArrayList<Post> getUserPosts() {
        Post p1=new Post("Post 1","Body of Post 1 by Shubham",new Date());
        Post p2=new Post("Post 2","Body of Post 2 by Shubham",new Date());
        Post p3=new Post("Post 3","Body of Post 3 by Shubham",new Date());
        // Creating list of posts
        ArrayList<Post> posts=new ArrayList<>();

        posts.add(p1);
        posts.add(p2);
        posts.add(p3);
        // Passing list of posts to the index using Model
        return posts;
    }

    public Post createPost(Post p) {
        p.setDate(new Date());
        System.out.println("Post Created Successfully");
        System.out.println("Title :::"+p.getTitle());
        System.out.println("Date :::"+p.getDate());
        System.out.println("Body :::"+p.getBody());
        return p; // this method will usually return null if the post is NOT created
        //(or added to the database successfully)

    }
}
