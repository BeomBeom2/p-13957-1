package com.back.domain.post.post.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Post {
    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
    private int id; // INT
    private String title; //VARCHAR(255) 이걸 JPA 가 해준다.
}
