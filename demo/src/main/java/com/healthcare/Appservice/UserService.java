package com.healthcare.Appservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.Appmodel.User;
import com.healthcare.Apprepository.UserRepository;

@Service
public class UserService implements UserDetailsService {
   
    @Autowired
    private UserRepository userRepository;

    @Override
    public String save(User user) {
       
        userRepository.save(user);

        return "User saved successfully";
    }
    
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username) {
        
        return userRepository.findByUsername(username);

    }
    
    // Add methods to interact with userRepository as needed

}
