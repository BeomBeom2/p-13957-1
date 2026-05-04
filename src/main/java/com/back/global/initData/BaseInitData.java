package com.back.global.initData;

import com.back.domain.post.post.entity.Post;
import com.back.domain.post.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration //빈, 내부에 @Bean 메서드 가질 수 있음
public class BaseInitData {
    @Autowired
    private PostRepository postRepository;

    @Bean //메서드는 스프링 부트가 시작할 때 자동으로 실행된다.
    ApplicationRunner baseInitDataApplicationRunner() {

        return args -> {
            work1();
            work2();
        };
    }

    void work1() {
        if(postRepository.count() > 0 ) return;

        Post post1 = postRepository.save(new Post("제목 1", "내용 1"));
        Post post2 = postRepository.save(new Post("제목 2", "내용 2"));

        System.out.println("기본 데이터가 초기화되었습니다.");
    }
    void work2() {
        Optional<Post> opPost1 = postRepository.findById(1);
        // SELECT * FROM post WHERE id = 1;
    }
}
