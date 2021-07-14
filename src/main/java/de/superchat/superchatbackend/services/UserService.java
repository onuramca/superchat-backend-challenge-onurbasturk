package de.superchat.superchatbackend.services;

import de.superchat.superchatbackend.model.User;
import de.superchat.superchatbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByUserId(Long userId) {
        return userRepository.getById(userId);
    }
}
