package com.hainguyen.blog.service;

import com.hainguyen.blog.model.Category;

public interface CategoryService {

    Iterable<Category> findAll();

    Category findById(Integer id);

    void save(Category category);

    void remove(Integer id);

}
