package com.example.blogapi.controllers;

import com.example.blogapi.models.Comment;
import com.example.blogapi.schemas.CommentSchema;
import com.example.blogapi.services.CommentService;
import com.example.blogapi.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    CommentService commentService;

    @Autowired
    PostService postService;

    @GetMapping("")
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody CommentSchema commentSchema) {
        Comment comment = new Comment();
        comment.setBody(commentSchema.body);
        comment.setPost(postService.getPostById(commentSchema.post));
        commentService.save(comment);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
