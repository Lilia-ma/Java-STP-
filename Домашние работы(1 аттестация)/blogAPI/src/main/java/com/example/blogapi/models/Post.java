package com.example.blogapi.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String body;
    private Date created;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;


}
