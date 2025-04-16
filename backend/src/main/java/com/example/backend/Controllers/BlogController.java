package com.example.backend.Controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.backend.Models.PostModel;
import com.example.backend.Repository.PostRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin("*")
public class BlogController {

    @Autowired
    PostRepository postRepo;

    
    @GetMapping("/api/Posts")
    public List<PostModel> getBlogs() {
        return postRepo.findAll();
    }

    @PostMapping("/api/Posts")
    public String postBlog(@RequestBody PostModel newPost) {
        postRepo.save(newPost);
        return "Post Added Successfully";
    }
    
    
    
}
