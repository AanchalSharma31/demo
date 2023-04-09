package com.example.demo.controllers;

import com.example.demo.modal.Blog;
import com.example.demo.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blog/{id}")
    public Blog listOfBlog(@PathVariable("id") Integer id) {
        return blogService.getBlogById(id);
    }

    @PostMapping("/blog/save")
    public Blog saveBlog(@RequestBody Blog blog) {
        return blogService.saveBlog(blog);
    }

    @PutMapping("/blog/{id}")
    public Blog update(@PathVariable Integer id, @RequestBody Map<String, String> body){
        return blogService.update(id, body);
    }

    @DeleteMapping("blog/{id}")
    public boolean delete(@PathVariable Integer id) {
        blogService.delete(id);
        return true;
    }

    @GetMapping("/blog/search")
    public List<Blog> getListOfBlogByText(@RequestParam(name = "title") String title) {

        return blogService.getListOfBlogByText(title);

    }

}
