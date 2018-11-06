package com.hainguyen.blog.controller;

import com.hainguyen.blog.model.BlogPersonal;
import com.hainguyen.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping("/index")
    public ModelAndView listBlog(){
        Iterable<BlogPersonal> blogPersonals = blogService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("blogPersonals", blogPersonals);
        return modelAndView;
    }
}
