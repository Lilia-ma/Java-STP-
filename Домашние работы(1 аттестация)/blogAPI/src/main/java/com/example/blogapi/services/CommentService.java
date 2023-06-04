package com.example.blogapi.services;

import com.example.blogapi.models.Comment;
import com.example.blogapi.repositories.CommentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CommentService {
    @Autowired
    CommentRepo commentRepo;

    public List<Comment> getAllComments() {
        return commentRepo.findAll();
    }

    public void save(Comment comment) {
        commentRepo.save(comment);
    }
}
