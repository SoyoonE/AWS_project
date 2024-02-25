package com.awsService.book.springboot.service.posts;

import com.awsService.book.springboot.domain.posts.Posts;
import com.awsService.book.springboot.domain.posts.PostsRepository;
import com.awsService.book.springboot.web.dto.PostsResponseDto;
import com.awsService.book.springboot.web.dto.PostsSaveRequestDto;
import com.awsService.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requsetDto) {
        return postsRepository.save(requsetDto.toEntity()).getId();
    }

    @Transactional
    public  Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }
    public PostsResponseDto findbyId (Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }
}
