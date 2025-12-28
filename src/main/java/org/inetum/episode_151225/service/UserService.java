package org.inetum.episode_151225.service;

import org.inetum.episode_151225.dto.UserRequest;
import org.inetum.episode_151225.dto.UserResponse;
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

    public List<UserResponse> getAllUsers()
    {
        return this.userRepository.findAll()
                .stream()
                .map(this::MapToUserResponse)
                .toList();
    }

    private UserResponse MapToUserResponse(User user)
    {
        UserResponse response = new UserResponse();
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        return response;
    }

    public User addUser(UserRequest user)
    {
        User u = new User();
        u.setEmail(user.getEmail());
        u.setName(user.getName());
        return this.userRepository.save(u);
    }
}
