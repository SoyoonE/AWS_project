package com.awsService.book.springboot.web;

import com.awsService.book.springboot.service.posts.PostsService;
import com.awsService.book.springboot.web.dto.PostsResponseDto;
import com.awsService.book.springboot.web.dto.PostsSaveRequestDto;
import com.awsService.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/vq/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id,requestDto);
    }
}
