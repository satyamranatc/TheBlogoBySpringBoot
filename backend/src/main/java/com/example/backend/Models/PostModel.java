package com.example.backend.Models;

import jakarta.persistence.*;

@Entity
public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String blogPoster;
    private String blogTitle;
    private String blogDesc;
    private String blogAuthor;

    public PostModel() {}

    public PostModel(String blogPoster,String blogTitle, String blogDesc, String blogAuthor) {
        this.blogPoster = blogPoster;
        this.blogTitle = blogTitle;
        this.blogDesc = blogDesc;
        this.blogAuthor = blogAuthor;
    }

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

    public String getBlogAuthor() {
        return blogAuthor;
    }

    public void setBlogAuthor(String blogAuthor) {
        this.blogAuthor = blogAuthor;
    }
}
