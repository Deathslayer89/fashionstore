package com.swan.fashionstore.controller;

import com.swan.fashionstore.exception.UserException;
import com.swan.fashionstore.modal.User;
import com.swan.fashionstore.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;
    public UserController(UserService userService) {
        this.userService=userService;
    }

    @GetMapping("/profile")
    public ResponseEntity<User> getUserProfileHandler(@RequestHeader("Authorization") String jwt) throws UserException {

        System.out.println("/api/users/profile");
        Optional<User> user=userService.findUserProfileByJwt(jwt);
        return new ResponseEntity<User>(user.get(), HttpStatus.ACCEPTED);
    }
}
