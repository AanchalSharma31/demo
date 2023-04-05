package com.example.demo.controllers;

import com.example.demo.dao.BlogRepository;
import com.example.demo.modal.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("/blog/{id}")
    public Blog listOfBlog(@PathVariable("id") Integer id) {
        return blogRepository.findById(id).get();
    }

    @PostMapping("/blog/save")
    public Blog saveBlog(@RequestBody Blog blog) {
        return blogRepository.save(blog);
    }

    @PutMapping("/blog/{id}")
    public Blog update(@PathVariable Integer id, @RequestBody Map<String, String> body){
        Blog blog = blogRepository.findById(id).get();
        blog.setTitle(body.get("title"));
        blog.setContent(body.get("content"));
        return blogRepository.save(blog);
    }

    @DeleteMapping("blog/{id}")
    public boolean delete(@PathVariable Integer id)
    {
        blogRepository.deleteById(id);
        return true;

    }
}
