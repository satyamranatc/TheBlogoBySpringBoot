package com.example.backend.Models;

import jakarta.persistence.*;


@Entity
public class UserModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String UserProfile;
    private String UserName;

    public UserModel() {}

    public UserModel(String UN, String UP) {
        this.UserName = UN;
        this.UserProfile = UP;
    }

    public Long getId() {
        return id;
    }

    public void setUserProfile(String Up) {
        UserProfile = Up;
    }

    public void setUserName(String Un) {
        UserName = Un;
        
    }
   
    public String getUserProfile() {
        return UserProfile;
    }

    public String getUserName() {
        return UserName;
    }
   


    
}
