package com.example.backend.Controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.backend.Models.PostModel;
import com.example.backend.Repository.PostRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/api/Posts/{id}")
    public Optional<PostModel> getBlogById(@PathVariable Long id) {
        return postRepo.findById(id);
    }

    @PostMapping("/api/Posts")
    public String postBlog(@RequestBody PostModel newPost) {
        postRepo.save(newPost);
        return "Post Added Successfully";
    }

    @PutMapping("/api/Posts/{id}")
    public String putBlog(@PathVariable Long id, @RequestBody PostModel newPost) {
        PostModel existingPost = postRepo.findById(id).orElse(null);

        if (existingPost == null) {
            return "Post Not Found with ID: " + id;
        }

        existingPost.setBlogTitle(newPost.getBlogTitle());
        existingPost.setBlogDesc(newPost.getBlogDesc());


        postRepo.save(existingPost);
        return "Post Updated Successfully";


    }
    @DeleteMapping("/api/Posts/{id}")
    public String putBlog(@PathVariable Long id)
    {
        PostModel existingPost = postRepo.findById(id).orElse(null);

        if (existingPost == null) {
            return "Post Not Found with ID: " + id;
        }
        postRepo.delete(existingPost);
        return null;
        
    }

}
