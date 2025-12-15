package org.inetum.episode_151225.service;

import org.inetum.episode_151225.model.User;
import org.inetum.episode_151225.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers()
    {
        return this.userRepository.findAll();
    }
}
