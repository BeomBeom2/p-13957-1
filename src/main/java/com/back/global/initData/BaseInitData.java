package com.back.global.initData;

import com.back.domain.post.post.entity.Post;
import com.back.domain.post.post.repository.PostRepository;
import com.back.domain.post.post.service.PostService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Configuration //빈, 내부에 @Bean 메서드 가질 수 있음
@RequiredArgsConstructor
public class BaseInitData {
    @Autowired
    @Lazy
    private BaseInitData self;

    private final PostService postService;

    @Bean
        //메서드는 스프링 부트가 시작할 때 자동으로 실행된다.
    ApplicationRunner baseInitDataApplicationRunner() {

        return args -> {
            self.work1();
            self.work2();
            new Thread(() -> self.work3()).start();
        };
    }

    @Transactional
    void work1() {
        if (postService.count() > 0) return;

        Post post1 = new Post("제목 1", "내용 1");
        postService.save(post1);
        Post post2 = postService.save(new Post("제목 1", "내용 2"));

        System.out.println(post1.getId());
        System.out.println(post2.getId());

        System.out.println("기본 데이터가 초기화되었습니다.");
    }

    @Transactional(readOnly = true)
    void work2() {
        Optional<Post> opPost1 = postService.findById(1);
        Post post1 = opPost1.get();
    }

    @Transactional
    void work3() {
        Optional<Post> opPost1 = postService.findById(1);

        Post post1 = opPost1.get();

        postService.modify(post1, "제목 1 수정", "내용 1 수정");

        if (true) throw new RuntimeException("work3에서 예외 발생");

        Optional<Post> opPost2 = postService.findById(2);
        Post post2 = opPost2.get();

        postService.modify(post2, "제목 2 수정", "내용 2 수정");
    }
}
