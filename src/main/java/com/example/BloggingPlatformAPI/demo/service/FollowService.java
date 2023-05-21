package com.example.BloggingPlatformAPI.demo.service;

import com.example.BloggingPlatformAPI.demo.model.Follow;
import com.example.BloggingPlatformAPI.demo.model.User;
import com.example.BloggingPlatformAPI.demo.repository.IFollowRepo;
import com.example.BloggingPlatformAPI.demo.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowService {
    @Autowired
    private IFollowRepo followRepo;
    @Autowired
    private IUserRepo userRepo;
    public String followings(Integer id1,Integer id2) {
        if(userRepo.findById(id1).isPresent() && userRepo.findById(id2).isPresent()){
            User userModel = userRepo.findById(id2).get();
            User userModel1 = userRepo.findById(id1).get();
            Follow follow=new Follow();
            follow.setFollowingUsers(userModel);
            follow.setUser(userModel1);
            Follow save = followRepo.save(follow);
            return save.toString();
        }
        else if(!userRepo.findById(id1).isPresent()){
            return "user 1 is not in the database";
        }
        else if(!userRepo.findById(id2).isPresent()) {
            return "user 2 is not in the database";
        }
        return "user 1 and user 2 are not in the database";
    }

    public Follow watchFollowers(Integer yourId) {
        if(userRepo.findById(yourId).isPresent()) {
            return followRepo.findById(yourId).get();
        }
        return null;
    }
}
