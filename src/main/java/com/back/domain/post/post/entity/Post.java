package com.back.domain.post.post.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Post {
    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
    private int id; // INT
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private String title; //VARCHAR(255) 이걸 JPA 가 해준다.
    @Column(columnDefinition = "TEXT")
    private String content;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
