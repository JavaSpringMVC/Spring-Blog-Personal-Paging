package com.hainguyen.blog.service.Impl;

import com.hainguyen.blog.model.BlogPersonal;
import com.hainguyen.blog.repository.BlogRepository;
import com.hainguyen.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;

public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Iterable<BlogPersonal> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public BlogPersonal findById(Integer id) {
        return blogRepository.findOne(id);
    }

    @Override
    public void save(BlogPersonal blogPersonal) {
        blogRepository.save(blogPersonal);
    }

    @Override
    public void remove(Integer id) {
        blogRepository.delete(id);
    }
}
