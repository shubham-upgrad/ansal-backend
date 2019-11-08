package ansaltechblogapp.controllers;

import ansaltechblogapp.models.Post;
import ansaltechblogapp.models.User;
import ansaltechblogapp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class PostController {
    @Autowired
    PostService postService;
    @RequestMapping("/posts")
    public String userPostsPage(Model model, HttpSession session){
        // Obtain the user from session whose posts are to be fetched
        User logged=(User)session.getAttribute("loggeduser");
        if(logged==null){
            return "user/login";
        }
        ArrayList<Post> posts=postService.getUserPosts();
        model.addAttribute("list_of_posts",posts);
        return "posts";
    }
    @RequestMapping("/post/create")
    public String createPostPage(){
        return "createpost.html";
    }
    @RequestMapping(value = "/post/create",method = RequestMethod.POST)
    public String createPost(Post p){
        Post created = postService.createPost(p);
        return "redirect:/posts"; // Redirect to page where user posts are available

    }

}
