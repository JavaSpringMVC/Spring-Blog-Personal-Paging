package com.hainguyen.blog.service;

import com.hainguyen.blog.model.BlogPersonal;

public interface BlogService {
    Iterable<BlogPersonal> findAll();

    BlogPersonal findById(Integer id);

    void save(BlogPersonal blogPersonal);

    void remove(Integer id);
}
