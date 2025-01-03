package com.marian.project.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.marian.project.model.User;
import com.marian.project.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public List<User> getAllUser(){
		return userRepository.findAll();
	}
    public String registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return "User already exists!";
        }
        userRepository.save(user);
        return "User registered successfully!";
    }
}