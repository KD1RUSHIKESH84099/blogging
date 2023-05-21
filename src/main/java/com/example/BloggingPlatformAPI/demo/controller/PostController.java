package com.example.BloggingPlatformAPI.demo.controller;

import com.example.BloggingPlatformAPI.demo.model.Post;
import com.example.BloggingPlatformAPI.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PostController {
    @Autowired
    private PostService postService;
    @PostMapping("add-post")
    public ResponseEntity<String> addPost(@RequestBody Post postModel){
        int id=postService.addPost(postModel);
        return new ResponseEntity<>("Post saved with postId -->"+id, HttpStatus.CREATED);
    }
    @GetMapping("read-post/{postId}")
    public ResponseEntity<String> readPost(@PathVariable Integer postId){
        if(postId!=null){
            Post post=postService.readPost(postId);
            return new ResponseEntity<>(post.toString(),HttpStatus.FOUND);
        }
        else{
            return  new ResponseEntity<>("please enter valid postId",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("read-all-posts")
    public ResponseEntity<List<Post>> readAllPosts(){
        List<Post> postModels=postService.readAllPosts();
        return new ResponseEntity<>(postModels,HttpStatus.FOUND);
    }
    @PutMapping("update-post/{postId}")
    public ResponseEntity<String> updatePost(@PathVariable Integer postId,@RequestBody Post postModel){
        String ans = postService.updatePost(postId,postModel);
        if(ans.equals("noData")){
            return new ResponseEntity<>("postId not found in the database please verify postId",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(ans,HttpStatus.OK);
    }
    @DeleteMapping("delete-post/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Integer postId){
        boolean ans=postService.deletePost(postId);
        if(ans){
            return new ResponseEntity<>("deleted Successful",HttpStatus.OK);
        }
        return new ResponseEntity<>("postId not found in the database please verify postId",HttpStatus.BAD_REQUEST);
    }
    @GetMapping("post-user/{userId}")
    public ResponseEntity<List<Post>> postUser(@PathVariable Integer userId){
        List<Post> list=postService.postAndUsers(userId);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
