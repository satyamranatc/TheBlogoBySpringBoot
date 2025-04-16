package com.example.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backend.Models.PostModel;

public interface PostRepository extends JpaRepository<PostModel,Long> {} 
