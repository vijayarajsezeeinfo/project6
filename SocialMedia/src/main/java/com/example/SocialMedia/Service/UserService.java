package com.example.SocialMedia.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SocialMedia.Model.User;
import com.example.SocialMedia.Repository.UserRepository;

@Service
public class UserService {
  @Autowired
  UserRepository userRepository;
  
  public void addUser(User user) {
	  if(!userRepository.findAll().contains(user)) {
		  userRepository.save(user);
	  }
  }
}
