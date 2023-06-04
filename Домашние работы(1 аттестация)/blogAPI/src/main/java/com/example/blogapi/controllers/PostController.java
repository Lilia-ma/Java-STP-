package com.example.blogapi.controllers;

import com.example.blogapi.models.Post;
import com.example.blogapi.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody Post post) {
        postService.save(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
