package com.social.demo.controller;


import com.social.demo.models.Post;
import com.social.demo.response.ApiResponse;
import com.social.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/posts/user/{userId}")
    public ResponseEntity<Post> createPost(@RequestBody Post post,@PathVariable Integer userId) throws Exception {
        Post createdPost = postService.createNewPost(post,userId);
        return new ResponseEntity<>(createdPost, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/posts/{postId}/user/{userId}")
    public  ResponseEntity<ApiResponse> deletedPost(@PathVariable Integer postId,
                                               @PathVariable Integer userId) throws Exception {
        String message = postService.deletePost(postId,userId);
        ApiResponse res = new ApiResponse(message,true);
        return new ResponseEntity<ApiResponse>(res,HttpStatus.OK);
    }

    @GetMapping("/post/{postId}")
    public  ResponseEntity<Post> findPostByIdHandler(@PathVariable Integer postId) throws Exception {
        Post post = postService.findPostById(postId);
        return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);
    }

    @GetMapping("/posts/user/{userId}")
    public ResponseEntity<List<Post>> findUsersPost(@PathVariable Integer userId){
        List<Post> posts = postService.findPostByUserId(userId);
        return  new ResponseEntity<List<Post>>(posts,HttpStatus.OK);

    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> findAllPost(){
        List<Post> posts = postService.findAllPost();
        return  new ResponseEntity<List<Post>>(posts,HttpStatus.OK);

    }

    @PutMapping("/posts/save/{postId}/user/{userId}")
    public  ResponseEntity<Post> savedPostHandler(@PathVariable Integer postId,
                                                  @PathVariable Integer userId) throws Exception {
        Post post = postService.savedPost(postId,userId);
        return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);
    }

    @PutMapping("/posts/like/{postId}/user/{userId}")
    public  ResponseEntity<Post> likePostHandler(@PathVariable Integer postId,
                                                  @PathVariable Integer userId) throws Exception {
        Post post = postService.likePost(postId,userId);
        return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);
    }




}
