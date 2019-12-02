package ansaltechblogapp.repositories;

import ansaltechblogapp.models.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.sql.*;
import java.util.ArrayList;

@Repository
public class PostRepository {
    @PersistenceUnit(unitName = "ansaltechblog")
    EntityManagerFactory emf;
    public ArrayList<Post> getAllPosts(){
        // Hardcoded Posts
//        Post p1=new Post("Post 1","Body of Post 1",new Date());
//        Post p2=new Post("Post 2","Body of Post 2",new Date());
//        Post p3=new Post("Post 3","Body of Post 3",new Date());
        // Creating list of posts
        ArrayList<Post> posts=new ArrayList<>();

        try{
            EntityManager em = emf.createEntityManager();
            // ORM is supposed translate b/w object oriented and relational dbms
            // So in TypedQuery we will define a query and its associated type
            // which specifies what kind of results are expected out of a query.
            // We will now ask EntityManager to create a TypedQuery
            // So entitmanager will obviously ask us : The Query(JPQL) and The Type
            // "SELECT p FROM Post p" -> JPQL that we provided
            // Post.class --> The class type of the result that we expect
            TypedQuery<Post> tq = em.createQuery("SELECT p from Post p", Post.class);
            // "SELECT p FROM Post p" -> This is not SQL this is JPQL
            // JPQL = Java Persistence Query Language
            // JPQL is closer to JAVA than SQL
            // Here we are saying : SELECT all Posts as p(because p is of type Post)
            //                      FROM a table that represents Post in RDBMS
            posts = (ArrayList<Post>) tq.getResultList(); // Will return a List(need to Downcast)

        }catch (Exception e) {
            e.printStackTrace();
        }
//        posts.add(p1);
//        posts.add(p2);
//        posts.add(p3);
        // Passing list of posts to the index using Model
        return posts;
    }

    public Post createPost(Post p) {
        // Create a post
        // So to edit a database...a transaction is required
        EntityManager em=emf.createEntityManager();
        EntityTransaction et=em.getTransaction();
        try{
            et.begin(); // Starting the transaction
            // Stuff that needs to be done during the transaction
            // Create a post
            em.persist(p); // Transient ---> Persisted
            et.commit();
            return p;
        }catch(Exception e){
            e.printStackTrace();
            et.rollback();
            return null;
        }
    }

    public Post getPostById(Integer id) {
        EntityManager em=emf.createEntityManager();
        return em.find(Post.class,id);
    }

    public void editPost(Post updatedPost) {

        try{
            EntityManager em=emf.createEntityManager();
            EntityTransaction et=em.getTransaction();
            et.begin();
            em.merge(updatedPost); // Transient/Detached ---> Managed(Persisted)
            et.commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deletePost(Integer id) {
        try{
            EntityManager em=emf.createEntityManager();
            EntityTransaction et=em.getTransaction();
            et.begin();
            Post p=em.find(Post.class,id);
            em.remove(p);
            et.commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
// Older JDBC Code :
// Class.forName will load the Driver class from org.postgresql package
// This executes the static block of Driver which registers the Type4 postgres driver
// with DriverManager
//            Class.forName("org.postgresql.Driver");
//                    String dbname="ansaltechblogdb";
//                    String user="postgres";
//                    String password="postgres@123";
//                    String host="localhost";
//                    String port="5432";
//                    String url = "jdbc:postgresql://"+host+":"+port+"/"+dbname;
//                    // url = "jdbc:postgresql://localhost:5432/ansaltechblogdb"
//                    // Then we pass this URL to DriverManager.getConnection()
//                    // Where it is matched with all the URL formats registered with DriverManager(when
//                    // Driver was registered)
//                    Connection conn = DriverManager.getConnection(url,user,password);
//                    // After getting a highway that connects our application to
//                    // the database...we want an associated TRUCK that will be used to deliver
//                    // our queries through the highway(The Highway is conn and stmt is the truck )
//                    Statement stmt = conn.createStatement();
//                    ResultSet rs = stmt.executeQuery("SELECT title,body,post_date from posts");
//                    // Traversing the ResultSet
////            rs.next() : returns True if there is a row ahead of the cursor and
////            MOVES THE CURSOR TO THE NEXT ROW
//                    while(rs.next()){ // While rs has a row...move to that row and . . .
//                    // Create a Post objecgt
//                    Post p=new Post();
//                    // Set the values of title,body and date using the data we have in ResultSet
//                    p.setTitle(rs.getString("title")); // Get title from current row
//                    p.setBody(rs.getString("body"));
//                    p.setDate(rs.getDate("post_date"));
//                    // Add the post so created to the array list
//                    posts.add(p);
//                    }
//
