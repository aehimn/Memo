package com.haemin.memo.post;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.haemin.memo.post.domain.Post;
import com.haemin.memo.post.service.PostService;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/post")
@Controller
public class PostController {
	
	private PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping("/list-view")
	public String postList(
			HttpSession session
			, Model model) {
		
		long userId = (Long)session.getAttribute("userId");
		
		List<Post> postList = postService.getPostList();
		
		model.addAttribute("memoList", postList);
		
		return "post/list";
	}
	
	@GetMapping("/create-view")
	public String inputPost() {
		return "post/input";
	}
	
	@GetMapping("/detail-view")
	public String postDetail(
			@RequestParam long id
			, Model model) {
		
		Post post = postService.getPost(id);
		
		
		
		
		
		return "post/detail";
	}

}
