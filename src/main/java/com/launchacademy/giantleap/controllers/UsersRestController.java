package com.launchacademy.giantleap.controllers;


import com.launchacademy.giantleap.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersRestController {
  @Autowired
  private UserService userService;

  @GetMapping("/api/v1/user")
  public User getUser(Authentication authentication) {
    org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User)authentication.getPrincipal();
    return user;
  }
}
