package com.awsService.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("select p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllById();
}
