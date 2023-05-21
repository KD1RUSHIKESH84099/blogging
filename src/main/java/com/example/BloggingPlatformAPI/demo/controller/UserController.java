package com.example.BloggingPlatformAPI.demo.controller;

import com.example.BloggingPlatformAPI.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.BloggingPlatformAPI.demo.model.User;

public class UserController {
    @Autowired
    private UserService usersService;
    @PostMapping("add-Users")
    public ResponseEntity<String> addUser(@Valid @RequestBody User userModel){
        String ans = usersService.addUser(userModel);
        if(ans.equals("true")) {
            return new ResponseEntity<>("User Saved with Id -->" + userModel.getUserId(), HttpStatus.CREATED);
        }
        else if(ans.equals("number")){
            return new ResponseEntity<>("please enter digits only",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("userName already exist please change userName",HttpStatus.BAD_REQUEST);
    }
}
