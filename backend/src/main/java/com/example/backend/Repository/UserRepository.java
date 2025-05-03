package com.example.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backend.Models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {}
