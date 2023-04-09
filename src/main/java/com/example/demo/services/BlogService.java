package com.example.demo.services;

import com.example.demo.dao.BlogRepository;
import com.example.demo.modal.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public Blog getBlogById(Integer id) {
        return blogRepository.findById(id).get();
    }

    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    public Blog update(Integer id, Map<String, String> body){
        Blog blog = blogRepository.findById(id).get();
        blog.setTitle(body.get("title"));
        blog.setContent(body.get("content"));
        return blogRepository.save(blog);
    }

    public boolean delete(Integer id) {
        blogRepository.deleteById(id);
        return true;
    }

    public List<Blog> getListOfBlogByText(String title) {
        return blogRepository.getBlogListByTitle(title);
    }
}
