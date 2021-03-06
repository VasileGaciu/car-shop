package com.car.shop.controller;

import com.car.shop.entity.Users;
import com.car.shop.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
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

    @GetMapping(path = "/all")
    @PreAuthorize(value = "hasAuthority('admin')")
    public List<Users> getAllUsers(){
        return  usersService.getAllUsers();
    }
    @GetMapping(path = "/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
      usersService.refreshToken(request, response);
    }

    @PostMapping(path = "/signup")
    public String saveUser(@RequestBody Users user){
       return  usersService.saveUser(user);
   }
   @PostMapping("/signup/admin")
   public String saveUserByAdmin(@RequestBody Users user){
      return usersService.saveUserByAdmin(user);
   }
   @DeleteMapping(path = "delete")
    public String deleteCurrentUser(@RequestBody Users user){
      return usersService.deleteCurrentUser(user);
   }
}
