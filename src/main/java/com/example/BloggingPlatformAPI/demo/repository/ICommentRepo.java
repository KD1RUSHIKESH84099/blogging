package com.example.BloggingPlatformAPI.demo.repository;

import com.example.BloggingPlatformAPI.demo.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepo extends JpaRepository<Comments,Integer> {
}
