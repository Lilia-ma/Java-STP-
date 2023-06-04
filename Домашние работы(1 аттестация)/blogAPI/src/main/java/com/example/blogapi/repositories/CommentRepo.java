package com.example.blogapi.repositories;

import com.example.blogapi.models.Comment;
import com.example.blogapi.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByPost (Post post);
}
