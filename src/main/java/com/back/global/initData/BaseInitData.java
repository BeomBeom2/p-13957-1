package com.back.global.initData;

import com.back.domain.post.post.entity.Post;
import com.back.domain.post.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //빈, 내부에 @Bean 메서드 가질 수 있음
public class BaseInitData {
    @Autowired
    private PostRepository postRepository;

    @Bean //메서드는 스프링 부트가 시작할 때 자동으로 실행된다.
    ApplicationRunner baseInitDataApplicationRunner() {
        return args -> {
            if(postRepository.count() > 0 ) return;

            Post post1 = new Post();
            post1.setTitle("제목 1");

            postRepository.save(post1);


            Post post2 = new Post();
            post2.setTitle("제목 2");

            postRepository.save(post2);

            postRepository.count(); //SELECT COUNT(*) FROM post;

            System.out.println("기본 데이터가 초기화되었습니다.");
        };
    }
}
