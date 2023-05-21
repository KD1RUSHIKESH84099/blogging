package com.example.BloggingPlatformAPI.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table

public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer followId;
    @NotNull(message = "user cannot be null")
    @ManyToOne
    private User user;
    @JoinColumn(name = "following")
    @NotNull(message = "followingUsers cannot be null")
    @ManyToOne
    private User followingUsers;
}
