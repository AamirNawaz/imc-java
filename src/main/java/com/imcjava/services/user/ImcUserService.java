package com.imcjava.services.user;

import com.imcjava.models.User;
import com.imcjava.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImcUserService {

    private final UserRepository userRepository;

    public ImcUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
