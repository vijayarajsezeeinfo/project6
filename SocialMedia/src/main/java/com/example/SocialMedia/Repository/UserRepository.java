package com.example.SocialMedia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SocialMedia.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
