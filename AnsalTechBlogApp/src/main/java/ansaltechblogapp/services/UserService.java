package ansaltechblogapp.services;

import ansaltechblogapp.models.User;
import ansaltechblogapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public User checkUser(User user) {
        return userRepository.checkUser(user);
    }

    public User registerUser(User user) {

        return userRepository.registerUser(user); // This method would usually return null if user is not successfully
        // registered(i.e, user could not be addded to the database)

    }
}
