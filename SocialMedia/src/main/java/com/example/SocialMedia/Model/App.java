package com.example.SocialMedia.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class App {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String appName;
  @ManyToMany
  @JoinTable(
		    name = "app_users",
		    joinColumns = @JoinColumn(name = "app_id"),
		    inverseJoinColumns = @JoinColumn(name = "user_id")
		)
  private List<User>users =new ArrayList<>();
}
