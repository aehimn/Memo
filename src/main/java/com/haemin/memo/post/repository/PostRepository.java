package com.haemin.memo.post.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haemin.memo.post.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	
	// WHERE `userId` = #{}
	public List<Post> findByUserId(long userId);

}
