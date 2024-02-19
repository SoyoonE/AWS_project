package com.awsService.book.springboot.service.posts;

import com.awsService.book.springboot.domain.posts.PostsRepository;
import com.awsService.book.springboot.web.dto.PostsSaveRequestDto;
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
}
