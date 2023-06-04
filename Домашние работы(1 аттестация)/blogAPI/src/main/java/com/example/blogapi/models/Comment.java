package com.example.blogapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "comments")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String body;

    @ManyToOne
    @JoinColumn(name = "post")
    @JsonIgnore
    private Post post;
}
