package com.security.controller;

import com.security.entity.User;
import com.security.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/")
public class UserController {

    private UserService userService;

    @GetMapping(path = "/hello")
    public ResponseEntity<String> helloWorld(){
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }
    @GetMapping(path = "/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping(path = "users/{username}")
    public ResponseEntity<User> findByUsername(@PathVariable String username){
        Optional<User> user = userService.findByUsername(username);
        if(!user.isPresent()){
          throw new UsernameNotFoundException("User not found");
        }
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }
}
