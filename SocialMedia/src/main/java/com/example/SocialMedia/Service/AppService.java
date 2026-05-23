package com.example.SocialMedia.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.SocialMedia.Model.App;
import com.example.SocialMedia.Model.User;
import com.example.SocialMedia.Repository.AppRepository;
import com.example.SocialMedia.Repository.UserRepository;

@Service
public class AppService {
 @Autowired
 AppRepository appRepository;
 @Autowired
 UserRepository userRepository;
 @Autowired
 UserService userService;
 
  public User addUser(User user, String appName) {
	  User savedUser=user;
  App  app=  appRepository.findByAppName(appName);
  List<User> appUsers= app.getUsers();
  if(!appUsers.contains(user)) {
	  appUsers.add(user);
	  userService.addUser(user); //adding user in user db via userService
  }
  app.setUsers(appUsers);
  appRepository.save(app);
          for(User u:appRepository.findByAppName(appName).getUsers()) {
        	  if(u.equals(user)) {
        		  savedUser=u;
        	  }
          }
  return savedUser;
  }
  
  public List<App> getAllApps(){
	  return appRepository.findAll();
  }
  
  public List<App> addApp(App app){
	  appRepository.save(app);
	  return appRepository.findAll();
  }
  
  public ResponseEntity<?> addFriends(Long userId, List<User> friends) {
     Optional<User> u=	  userRepository.findById(userId);
	  if(u.isEmpty()) {
		  return new ResponseEntity<>("No Such user found to add Friends",HttpStatus.NOT_FOUND);
	  }else {
		  User user=u.get();
		  for(User u2:friends) {
			  if(!user.getFriends().contains(u2)) {
				  user.getFriends().add(u2);
			  }
		  }
		  userRepository.save(user);
		  
		 return new ResponseEntity<>(userRepository.findById(userId),HttpStatus.CREATED);
	  }
  }
}
