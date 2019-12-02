package ansaltechblogapp.controllers;

import ansaltechblogapp.models.Post;
import ansaltechblogapp.models.User;
import ansaltechblogapp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
        ArrayList<Post> posts=postService.getAllPosts();
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

    @RequestMapping("/editPost")
    public String editPostPage(@RequestParam(name = "postId")Integer id,Model model){
        Post p=postService.getPostById(id);
        model.addAttribute("post",p);
        return "post/edit";
    }
    @RequestMapping(value = "/editPost",method = RequestMethod.POST)
    public String editPost(Post updatedPost){
        postService.editPost(updatedPost);
        return "redirect:/posts";
    }
    @RequestMapping("/deletePost")
    public String deletePost(@RequestParam("postId")Integer id){
        postService.deletePost(id);
        return "redirect:/posts";
    }
}
