package org.inetum.episode_151225.controller;

import org.inetum.episode_151225.model.User;
import org.inetum.episode_151225.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService)
    {
        this.userService = userService;
    }
    @GetMapping
    public List<User> getAllUsers()
    {
        return this.userService.getAllUsers();
    }
}
