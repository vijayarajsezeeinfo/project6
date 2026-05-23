package com.example.SocialMedia.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SocialMedia.Model.App;
import com.example.SocialMedia.Model.User;
import com.example.SocialMedia.Repository.AppRepository;
import com.example.SocialMedia.Service.AppService;

@RestController
public class AppController {
     @Autowired
     AppService appService;
     
     @Autowired
     AppRepository appRepository;
     
     @PostMapping("/{app}")
     public App addUser(@RequestBody User user, @PathVariable("app") String app) {
    	User u= appService.addUser(user, app);
    	 return appRepository.findByAppName(app);
     }
     @PostMapping("/")
     public List<App> addApp(@RequestBody App app){
    	 return appService.addApp(app);
     }
     
     @GetMapping("/")
     public List<App> getAllApps(){
    	 return appService.getAllApps();
     }
     
     @PutMapping("/{userId}")
     public ResponseEntity<?> addFriends( @PathVariable("userId") Long id,@RequestBody List<User> friends){
    	 return appService.addFriends(id, friends);
     }
     
     
}
