package com.example.BloggingPlatformAPI.demo.service;

import com.example.BloggingPlatformAPI.demo.model.User;
import com.example.BloggingPlatformAPI.demo.repository.IPostRepo;
import com.example.BloggingPlatformAPI.demo.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private IUserRepo userRepo;
    @Autowired
    private IPostRepo postRepo;

    public String addUser(User userModel){
        List<User> byUserName = userRepo.findByUserName(userModel.getUserName());
        String number = userModel.getNumber();
        for(int i=0;i<number.length();i++){
            if(!Character.isDigit(number.charAt(i))){
                return "number";
            }
        }
        if(byUserName.isEmpty()){
            User save = userRepo.save(userModel);
            return "true";
        }
        return "false";
    }

}
