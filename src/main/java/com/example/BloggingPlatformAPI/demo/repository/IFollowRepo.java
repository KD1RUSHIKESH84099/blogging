package com.example.BloggingPlatformAPI.demo.repository;

import com.example.BloggingPlatformAPI.demo.model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFollowRepo extends JpaRepository<Follow,Integer> {
}
