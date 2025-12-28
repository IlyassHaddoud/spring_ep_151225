package org.inetum.episode_151225.controller;

import jakarta.validation.Valid;
import org.inetum.episode_151225.dto.UserRequest;
import org.inetum.episode_151225.dto.UserResponse;
import org.inetum.episode_151225.model.User;
import org.inetum.episode_151225.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<UserResponse>> getAllUsers()
    {
        List<UserResponse> users = this.userService.getAllUsers();
        if(users.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@Valid @RequestBody UserRequest request)
    {
        User user = this.userService.addUser(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(user);
    }

}
