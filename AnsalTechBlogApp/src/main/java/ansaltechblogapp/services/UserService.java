package ansaltechblogapp.services;

import ansaltechblogapp.models.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User checkUser(User user) {
        if(user.getUsername().equals("Hitesh") && user.getPassword().equals("Malvika@123")){
            return user;
        }
        else{
            return null;
        }
    }
}
