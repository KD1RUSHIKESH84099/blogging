package com.example.BloggingPlatformAPI.demo.repository;

import com.example.BloggingPlatformAPI.demo.model.Post;
import com.example.BloggingPlatformAPI.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPostRepo extends JpaRepository<Post,Integer> {
    @Query(value = "select * from post_model where user_id_user_id=:userId",nativeQuery = true)
    List<Post> findPostByUserId(User userId);


}
