package com.car.shop.controller;

import com.car.shop.entity.Users;
import com.car.shop.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UsersController {

    private UsersService usersService;
    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/all")
    public List<Users> getAllUsers(){
        return  usersService.getAllUsers();
    }
    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
      usersService.refreshToken(request, response);
    }

    @PostMapping()
    public String saveUser(@RequestBody Users user){
       return  usersService.saveUser(user);
   }
}
