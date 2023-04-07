package com.example.demo.services;

import com.example.demo.dao.CommentRepository;
import com.example.demo.modal.Blog;
import com.example.demo.modal.Comment;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private BlogService blogService;

     public Comment saveComment(Comment comment, Integer blogId){
         Blog blog = blogService.getBlogById(blogId);
        return commentRepository.save(comment);
    }
}
