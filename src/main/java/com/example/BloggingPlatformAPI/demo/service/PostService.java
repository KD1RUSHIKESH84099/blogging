package com.example.BloggingPlatformAPI.demo.service;

import com.example.BloggingPlatformAPI.demo.model.Post;
import com.example.BloggingPlatformAPI.demo.model.User;
import com.example.BloggingPlatformAPI.demo.repository.IUserRepo;
import com.example.BloggingPlatformAPI.demo.repository.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PostService {
    @Autowired
    private IPostRepo postRepo;
    @Autowired
    private IUserRepo userRepo;
    public int addPost(Post postModel) {
        Post save = postRepo.save(postModel);
        return save.getPostId();
    }

    public Post readPost(Integer postId) {
        return postRepo.findById(postId).get();
    }

    public List<Post> readAllPosts() {
        return postRepo.findAll();
    }

    public String updatePost(Integer postId,Post postModel) {
        if(postRepo.findById(postId).isPresent()){
            Post postModel1 = postRepo.findById(postId).get();
            postModel1.setPostDescription(postModel.getPostDescription());
            postModel1.setPostName(postModel.getPostName());
            Post save = postRepo.save(postModel1);
            return save.toString();
        }else{
            return "noData";
        }
    }

    public boolean deletePost(Integer postId) {
        if(postRepo.findById(postId).isPresent()){
            postRepo.deleteById(postId);
            return true;
        }
        return false;
    }

    public List<Post> postAndUsers(Integer userId) {
        if(userRepo.findById(userId).isPresent()) {
            User userModel = userRepo.findById(userId).get();
            return postRepo.findPostByUserId(userModel);
        }
        else{
            return new ArrayList<>();
        }
    }
}
