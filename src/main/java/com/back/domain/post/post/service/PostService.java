package com.back.domain.post.post.service;

import com.back.domain.post.post.entity.Post;
import com.back.domain.post.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public long count() {
        return postRepository.count();
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public Optional<Post> findById(int id) {
        return postRepository.findById(id);
    }

    public void modify(Post post, String title, String content) {
        boolean changed = false;

        if(!post.getTitle().equals(title) ) {
            post.setTitle(title);
            changed = true;
        }

        if(!post.getContent().equals(content) ) {
            post.setContent(content);
            changed = true;
        }

        post.setTitle(title);
        post.setContent(content);

        if(changed) post.setModifyDate(LocalDateTime.now());

        postRepository.save(post);
    }
}