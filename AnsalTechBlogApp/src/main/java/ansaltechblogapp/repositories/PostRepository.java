package ansaltechblogapp.repositories;

import ansaltechblogapp.models.Post;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class PostRepository {
    public ArrayList<Post> getAllPosts(){
        // Hardcoded Posts
//        Post p1=new Post("Post 1","Body of Post 1",new Date());
//        Post p2=new Post("Post 2","Body of Post 2",new Date());
//        Post p3=new Post("Post 3","Body of Post 3",new Date());
        // Creating list of posts
        ArrayList<Post> posts=new ArrayList<>();
        try{
            // Class.forName will load the Driver class from org.postgresql package
            // This executes the static block of Driver which registers the Type4 postgres driver
            // with DriverManager
            Class.forName("org.postgresql.Driver");
            String dbname="ansaltechblogdb";
            String user="postgres";
            String password="postgres@123";
            String host="localhost";
            String port="5432";
            String url = "jdbc:postgresql://"+host+":"+port+"/"+dbname;
            // url = "jdbc:postgresql://localhost:5432/ansaltechblogdb"
            // Then we pass this URL to DriverManager.getConnection()
            // Where it is matched with all the URL formats registered with DriverManager(when
            // Driver was registered)
            Connection conn = DriverManager.getConnection(url,user,password);
            // After getting a highway that connects our application to
            // the database...we want an associated TRUCK that will be used to deliver
            // our queries through the highway(The Highway is conn and stmt is the truck )
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT title,body,post_date from posts");
            // Traversing the ResultSet
//            rs.next() : returns True if there is a row ahead of the cursor and
//            MOVES THE CURSOR TO THE NEXT ROW
            while(rs.next()){ // While rs has a row...move to that row and . . .
                // Create a Post objecgt
                Post p=new Post();
                // Set the values of title,body and date using the data we have in ResultSet
                p.setTitle(rs.getString("title")); // Get title from current row
                p.setBody(rs.getString("body"));
                p.setDate(rs.getDate("post_date"));
                // Add the post so created to the array list
                posts.add(p);
            }


        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


//        posts.add(p1);
//        posts.add(p2);
//        posts.add(p3);
        // Passing list of posts to the index using Model
        return posts;
    }

}
