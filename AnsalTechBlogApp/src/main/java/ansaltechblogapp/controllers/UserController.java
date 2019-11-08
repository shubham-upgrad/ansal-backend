package ansaltechblogapp.controllers;

import ansaltechblogapp.models.User;
import ansaltechblogapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/user/login") // Default request method is GET
    public String loginPage(){
        return "user/login";
    }
    // URL is same as above but Request Method is
    // POST
    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public String login(User user, HttpSession session){
        // Ask Service to check the credentials of this user
        User check=userService.checkUser(user);
        if(check==null){
            return "user/login";
        }else{
            session.setAttribute("loggeduser",check);
            return "redirect:/posts";
        }

    }
    @RequestMapping("/user/registration")
    public String registerPage(){
        return "user/registration";
    }
    @RequestMapping(value="/user/registration",method=RequestMethod.POST)
    public String register(User user){
        User registered=userService.registerUser(user);
        if(registered!=null){
            return "user/login";
        }
        return "user/registration";
    }
    @RequestMapping(value = "/user/logout",method = RequestMethod.POST)
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
