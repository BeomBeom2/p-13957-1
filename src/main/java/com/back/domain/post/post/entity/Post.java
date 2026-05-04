package com.back.domain.post.post.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Post {
    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
    private int id; // INT
    private final String title; //VARCHAR(255) 이걸 JPA 가 해준다.
    @Column(columnDefinition = "TEXT")
    private final String content;

    public Post() {
        this.title = "";
        this.content = "";
    }
}
