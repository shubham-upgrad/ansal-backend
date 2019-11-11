package ansaltechblogapp.services;

import ansaltechblogapp.models.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User checkUser(User user) {
        if(user.getUsername().equals("Hitesh") && user.getPassword().equals("Hitesh@123")){
            return user;
        }
        else{
            return null;
        }
    }

    public User registerUser(User user) {
        System.out.println("User successfully registered with following details:::");
        System.out.println("Username:::"+user.getUsername());
        System.out.println("Password:::"+user.getPassword());
        return user; // This method would usually return null if user is not successfully
        // registered(i.e, user could not be addded to the database)

    }
}
