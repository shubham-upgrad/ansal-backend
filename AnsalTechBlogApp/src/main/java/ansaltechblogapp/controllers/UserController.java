package ansaltechblogapp.controllers;

import ansaltechblogapp.models.User;
import ansaltechblogapp.models.UserProfile;
import ansaltechblogapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String registerPage(Model model){
        User u=new User(); // Created a user but profile is null for 'u'
        UserProfile profile=new UserProfile(); // Created a profile
        u.setProfile(profile); // Giving 'profile' to 'u' so that profile isn't
        // null anymore
        // Sending this object to the registration page to be used when
        // filling the form
        model.addAttribute("User",u);
        return "user/registration";
    }
    @RequestMapping(value="/user/registration",method=RequestMethod.POST)

    public String register(User user){
        // Now the user that is received from Thymeleaf template : registration.html
        //      is having profile with all values set(as provided by the end-user)
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
