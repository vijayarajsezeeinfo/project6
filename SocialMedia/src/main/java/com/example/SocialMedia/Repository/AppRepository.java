package com.example.SocialMedia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SocialMedia.Model.App;
import java.util.List;


public interface AppRepository extends JpaRepository<App, Long> {
      App findByAppName(String appName);
}
