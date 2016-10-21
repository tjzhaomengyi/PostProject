package com.tools;

import java.util.List;

import com.orm.Post;
import com.service.IPostService;
import com.serviceImpl.PostServiceImpl;

public class StaticNumber {
	static IPostService postService = new PostServiceImpl();
	
	static int total;
	
	public static int totalPost(){
		return 1;
	}
	
	public static long give(){
		return System.currentTimeMillis();
	}
	public static List<Post> posts(){
		return postService.allPost();
	}
	
}
