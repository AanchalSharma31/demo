package com.example.demo.controllers;

import com.example.demo.modal.Blog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class BlogController {

    @GetMapping("/blog")
    public List<?> listOfBlog() {
        List<Blog> blogs = new ArrayList<>();
        Blog blog1 = new Blog();
        blog1.setId(8);
        blog1.setTitle("Ram");
        blog1.setContent("jai ram ji ki");
        blogs.add(blog1);
        return blogs;
    }

}
