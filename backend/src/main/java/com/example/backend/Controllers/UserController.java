package com.example.backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.backend.Models.UserModel;
import com.example.backend.Repository.UserRepository;

import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserRepository userRepo;

    @PostMapping("/api/Users")
    public String postUser(@RequestBody UserModel user) {
        userRepo.save(user);
        return "User Added Successfully";
    }

    @GetMapping("/api/Users")
    public List<UserModel> getUsers() {
        return userRepo.findAll();
    }
}
