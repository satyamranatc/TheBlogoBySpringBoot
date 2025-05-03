package com.example.backend.Models;

import jakarta.persistence.*;
import com.example.backend.Models.UserModel;

@Entity
public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String blogPoster;
    private String blogTitle;
    private String blogDesc;

    // 👇 This is now the author (User is the author)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id") 
    
    private UserModel user;

    public PostModel() {}

    public PostModel(String blogPoster, String blogTitle, String blogDesc, UserModel user) {
        this.blogPoster = blogPoster;
        this.blogTitle = blogTitle;
        this.blogDesc = blogDesc;
        this.user = user;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public String getBlogPoster() {
        return blogPoster;
    }

    public void setBlogPoster(String blogPoster) {
        this.blogPoster = blogPoster;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogDesc() {
        return blogDesc;
    }

    public void setBlogDesc(String blogDesc) {
        this.blogDesc = blogDesc;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
