package ansaltechblogapp.controllers;

import ansaltechblogapp.models.Post;
import ansaltechblogapp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;

@Controller // A controller is a Component
public class HomeController {
    @Autowired
    PostService postService;




    /*** This method is supposed to pass posts(plural) to the "index"
     *  1. It must create Posts that are to be passed
     *  2. It must pass all the posts at once...
     *          - It will create an arraylist of posts
     *  4. Pass that arraylist to the index
     *          - For this...there is a class called Model(Not the model Post...it is a class)
     *          - Model is a class that helps you to send data to your views
     * @return view-name
     */
    @RequestMapping("/")
    public String index(Model model){
        ArrayList<Post> posts=postService.getAllPosts();
        model.addAttribute("list_of_posts",posts);

        // list_of_posts is the name using which your index page will access the list
        return "index";
    }
}
