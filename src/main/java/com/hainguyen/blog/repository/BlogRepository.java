package com.hainguyen.blog.repository;

import com.hainguyen.blog.model.BlogPersonal;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BlogRepository extends PagingAndSortingRepository<BlogPersonal, Integer> {
}
