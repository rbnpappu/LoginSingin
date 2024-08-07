package com.LoginSingin.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.LoginSingin.entity.RegisterUser;
import com.LoginSingin.repository.UserDataRepository;

@Service
public class UserService {
    
    private final UserDataRepository userDataRepository;

    @Autowired
    public UserService(UserDataRepository userDataRepository) {
        this.userDataRepository = userDataRepository;
    }

    public RegisterUser save(RegisterUser user) {
        return userDataRepository.save(user);
    }

    public String login(String name, String password) {
        String message;

        // First check if a user with the given name exists
        boolean nameExists = userDataRepository.existsByName(name);

        if (!nameExists) {
            message = "User with the name " + name + " does not exist.";
        } else {
            // Assuming there's a method to find a user by name and then check password
            RegisterUser user = userDataRepository.findByName(name);
            if (user != null && user.getPassword().equals(password)) {
                message = "Thank you for signing in, " + name;
            } else {
                message = "Invalid password for user " + name;
            }
        }
        
        return message;
    }

	public Map<String, ?> get() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean existsByName(String name) {
		// TODO Auto-generated method stub
		return userDataRepository.existsByName(name);
	}
}

