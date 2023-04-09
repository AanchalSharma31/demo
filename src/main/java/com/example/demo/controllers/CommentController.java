package com.example.demo.controllers;

import com.example.demo.modal.Comment;
import com.example.demo.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/comment/save/{blogId}")
    public Comment saveComment(@RequestBody Comment comment, @PathVariable("blogId") Integer blogId){

        return commentService.saveComment(comment, blogId);
    }
}
