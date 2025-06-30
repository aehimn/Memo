package com.haemin.memo.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haemin.memo.post.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
